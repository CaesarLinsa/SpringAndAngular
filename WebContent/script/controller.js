
app.controller("myController",function($scope,$http){
    	 $scope.say=function(){	  
    		 $http({
    			 method: "get",
                 url: "user/add",
               params:
                  { userName: "caer",
                   passWord: "123",
                   gender: "mal",
                   age: 23
                   }
               
    		 }).success(
                 console.log("okkkk")
             ).error(
                console.log("not okkk")    	       
     ); 
  }; 
     }).controller('loginCtr',['$scope','$http','$location','$cookieStore',function($scope,$http,$location,$cookieStore){
    	 $scope.login=function(){
    		 $http({
    			method: "post",
    			url: "user/login",
    			params: {
    				userName: $scope.form.userName,
    				passWord: $scope.form.password
    			}
    		 }).success(function(data){
                 $cookieStore.put("userName",$scope.form.userName);
    			 $location.path("home/menu/login_success");
                 $cookieStore.put('status',data.msg);
    		 }).error(function(data){
    			 $scope.result=data.msg;
    		 });
    	 }; 
     }]).controller("login_successCtr",['$scope','$cookieStore',function($scope,$cookieStore){
        var username=$cookieStore.get("userName"); 
        var status=$cookieStore.get("status");
    	 $scope.result=username+status;
  }]).controller('registerCtrl',['$scope','$http','$location',function($scope,$http,$location){


    $scope.register = function() {

        if ($scope.checkMatch()) {

            $http({
                method: 'post',
                url: 'user/add',
                data: $scope.form
            }).success(
               $location.path('home/menu/login')
            ).error(
                console.log("notokkkkkkkkk")
            )

        }
        else{
            angular.forEach($scope.registerForm,function(e){
                if(typeof(e) == 'object' && typeof(e.$dirty) == 'boolean'){
                    e.$dirty = true;
                }
            });
        }
    };

    $scope.checkMatch = function(){
        var form = $scope.form;
        if(form.passWord && form.passwordConfirm){
            if(form.passWord!=form.passwordConfirm){
                return false;
            }
        }
        return true;
    };

}]).controller('fileUploadCtrl',['$scope','$http','$cookieStore','$q','$interval',function($scope,$http,$cookieStore, $q,$interval){
    $scope.file_upload = function () {
    	 var total;
    	 var persent;
         var form = new FormData();
         var file = document.getElementById("file_upload").files[0];
         form.append('file', file);
         var userName = $cookieStore.get('userName');
         form.append('userName', userName);
         $http({
             method: 'POST',
             url: 'file/upload',
             headers: {'Content-Type': undefined},
             transformRequest: angular.identity,
             data: form
         }).success(function(){
             alert("okkkkkkkkk");
         });
         var run=$interval(function(){
             $http({
                 method: 'POST',
                 url: 'file/upload/progress'
             }).success(function (data) {
                 $scope.width=data+'%';
                 console.log(data);
                 if(data == 100){
                      $interval.cancel(run);
                 }

             })
         },700)

     }
}]).controller('fileDownloadCtrl',function($scope,$http){
        $http({
            method: 'POST',
            url: 'file/file_init'
        }).success(function(data){
            $scope.Files=data;
        })

});
   
   
 