angular.module('home.services', [])

.service('HomeImageService', function(){
   /**
   * TODO: API to get the slides, also the redirect url
   * The images should be resized
   **/
   this.slideimgs = [
       {
         image:"http://p2.qhimg.com/dmt/1000_369_/t01ff0b9c296fc4e8b3.jpg",
         url:"redirect url"
       },
       {
         image:"http://p8.qhimg.com/dmt/1000_369_/t01a5424b4f40db76c8.jpg",
         url:"redirect url"
       },
       {
         image:"http://p4.qhimg.com/dmt/1000_369_/t01e11308552f3c244f.jpg",
         url:"redirect url"
       }
     ];
   }
);
