angular.module('starter.controllers', [])

.controller('HomeCtrl', function($scope, $ionicSlideBoxDelegate, HomeImageService) {
  $scope.model = {
    activeIndex:0
  };

  $scope.slideimgs = HomeImageService.slideimgs;

  /**
  * jump to the des when click the show graph
  **/
  $scope.href=function(url){
    alert(url);
  }
})


.controller('MyPhotoCtrl', function($scope, MyPhotoService) {
  // With the new view caching in Ionic, Controllers are only called
  // when they are recreated or on app start, instead of every page change.
  // To listen for when this page is active (for example, to refresh data),
  // listen for the $ionicView.enter event:
  //
  //$scope.$on('$ionicView.enter', function(e) {
  //});
  //init the works
  $scope.myPhotos = MyPhotoService.myPhotos;

  $scope.doRefresh = function(){
    /**
    *TODO: ajax to get the users' works
    **/
    //angular.element("#dynamicPhoto").append("refresh");
    //alert("refresh");
    return;
  };

})

.controller('AccountCtrl', function($scope) {
  $scope.settings = {
    enableFriends: true
  };
});
