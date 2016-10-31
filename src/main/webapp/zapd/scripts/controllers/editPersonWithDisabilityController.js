

angular.module('zapd').controller('EditPersonWithDisabilityController', function($scope, $routeParams, $location, flash, PersonWithDisabilityResource ) {
    var self = this;
    $scope.disabled = false;
    $scope.$location = $location;
    
    $scope.get = function() {
        var successCallback = function(data){
            self.original = data;
            $scope.personWithDisability = new PersonWithDisabilityResource(self.original);
        };
        var errorCallback = function() {
            flash.setMessage({'type': 'error', 'text': 'The personWithDisability could not be found.'});
            $location.path("/PersonWithDisabilities");
        };
        PersonWithDisabilityResource.get({PersonWithDisabilityId:$routeParams.PersonWithDisabilityId}, successCallback, errorCallback);
    };

    $scope.isClean = function() {
        return angular.equals(self.original, $scope.personWithDisability);
    };

    $scope.save = function() {
        var successCallback = function(){
            flash.setMessage({'type':'success','text':'The personWithDisability was updated successfully.'}, true);
            $scope.get();
        };
        var errorCallback = function(response) {
            if(response && response.data && response.data.message) {
                flash.setMessage({'type': 'error', 'text': response.data.message}, true);
            } else {
                flash.setMessage({'type': 'error', 'text': 'Something broke. Retry, or cancel and start afresh.'}, true);
            }
        };
        $scope.personWithDisability.$update(successCallback, errorCallback);
    };

    $scope.cancel = function() {
        $location.path("/PersonWithDisabilities");
    };

    $scope.remove = function() {
        var successCallback = function() {
            flash.setMessage({'type': 'error', 'text': 'The personWithDisability was deleted.'});
            $location.path("/PersonWithDisabilities");
        };
        var errorCallback = function(response) {
            if(response && response.data && response.data.message) {
                flash.setMessage({'type': 'error', 'text': response.data.message}, true);
            } else {
                flash.setMessage({'type': 'error', 'text': 'Something broke. Retry, or cancel and start afresh.'}, true);
            }
        }; 
        $scope.personWithDisability.$remove(successCallback, errorCallback);
    };
    
    
    $scope.get();
});