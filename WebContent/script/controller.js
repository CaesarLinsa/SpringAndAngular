
var values;

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
    			 values=data.msg;
    			 alert(values)
    		 }).error(function(data){
    			 $scope.result=data.msg;
    		 });
    	 }; 
     }]).controller("login_successCtr",['$scope','$cookieStore',function($scope,$cookieStore){
        var username=$cookieStore.get("userName"); 
    	 $scope.result=username+values;
  }]).controller('registerCtrl',['scope','$http',function($scope,$http){

     if($scope.checkMatch()){

         $http({
              method: 'post',
              url: 'user/add',
              params: $scope.form
         }).success(
             console.log("okkkkkkkk")
         ).error(
             console.log("notokkkkkkkkk")
         )

     }




    $scope.checkMatch=function(){
        var form = $scope.form;
        if(form.passWord && form.passwordConfirm){
            if(form.passWord!=form.passwordConfirm){
                return false;
            }
        }
            return true;
    };

}]);
   
   
 