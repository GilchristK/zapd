angular.module('zapd').factory('PersonWithDisabilityResource', function($resource){
    var resource = $resource('../rest/personwithdisabilities/:PersonWithDisabilityId',{PersonWithDisabilityId:'@id'},{'queryAll':{method:'GET',isArray:true},'query':{method:'GET',isArray:false},'update':{method:'PUT'}});
    return resource;
});