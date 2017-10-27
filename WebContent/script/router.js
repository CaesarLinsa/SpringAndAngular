   var app=angular.module("myapp",['ui.router','ngCookies'])
   /****
    *路由 模板设置
    */
   .config(['$stateProvider','$urlRouterProvider',function($stateProvider,$urlRouterProvider){
	  $urlRouterProvider.otherwise("/home/menu");
	   $stateProvider.state("home",{
		   url: "/home",
		   views: {
			   "head":{
				   templateUrl: 'html/head.html' 
			   },
			   "content": {
				   
				   templateUrl: 'html/content.html'
			   },
			   "foot": {
				   
				   templateUrl: 'html/foot.html'
			   }
			   
		   }		   
	   }).state("home.menu",{
     /* 在加载子URL时必须先加载父url，父子链接一起，此加载子为/home/menu*/	   
           url: '/menu' ,
           views: {
        	    "menu": {
        	    	templateUrl: 'html/menu.html'
        	    },
           }
	   }).state("home.menu.login",{
		   //对应home状态下页面中 <div ui-view="info">
		   //显示url为/home/menu/menu1
		   url:'/login',
		   views: {
			   "info@home": {
				   templateUrl: 'html/login.html',
				   controller: 'loginCtr'
			   }
		   }
	   }).state("home.menu.login_success",{
		   url: '/login_success',
		   views: {
			    "info@home": {
			    	  templateUrl: 'html/login_success.html',
					  controller: 'login_successCtr'
			    } 
			   
		   }
	   }).state('home.menu.register', {

           url: '/register',
           views: {
               "info@home": {
                   templateUrl: 'html/register.html',
                   controller: 'registerCtrl'
               }
           }

       }).state('home.menu.file_upload',{
           url: '/file_upload',
           views: {
               'info@home': {
                   templateUrl: 'html/add_file.html' ,
                   controller: 'fileUploadCtrl'
               }
           }
       }).state('home.menu.file_download',{

           url: '/download',
           views: {

               'info@home': {
                   templateUrl: 'html/download_file.html',
                   controller: 'fileDownloadCtrl'

               }
           }

       });



   }]);
