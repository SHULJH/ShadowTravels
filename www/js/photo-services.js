angular.module('photo.services', [])

.service('MyPhotoService', function(){
  this.myPhotos = [
    {
      username  : "lijiahua",
      face      : "http://imglf1.ph.126.net/JFMSTHQ-NDy3LxtfbojuIQ==/6608459607608458240.jpg",
      content   : "Hey man, this is just a test for my-photo page.",
      datetime  : "October 1, 2015",
      cover     : "http://imglf0.nosdn.127.net/img/OERRYzRCdVVPNGFNZzFuOU5aWjBWUEZNeVgyVHd6NWk1K3Bvd1pORTJMS0p0c1pRWm0vUmRRPT0.jpg?imageView&thumbnail=1680x0&quality=96&stripmeta=0&type=jpg",
      likenum   : "1",
      commentnum : "5"
    },
    {
      username  : "lijiahua",
      face      : "http://imglf1.ph.126.net/JFMSTHQ-NDy3LxtfbojuIQ==/6608459607608458240.jpg",
      content   : "*********************************************************************************************************<br></br>*******\nIt's so long, however, you finished reading it.",
      datetime  : "October 1, 2015",
      cover     : "http://imglf0.nosdn.127.net/img/OERRYzRCdVVPNGFNZzFuOU5aWjBWUEZNeVgyVHd6NWk1K3Bvd1pORTJMS0p0c1pRWm0vUmRRPT0.jpg?imageView&thumbnail=1680x0&quality=96&stripmeta=0&type=jpg",
      likenum   : "1",
      commentnum : "5"
    }
  ];
});
