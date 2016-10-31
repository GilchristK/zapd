
angular.module('zapd').controller('NewPersonWithDisabilityController', function ($scope, $location, locationParser, flash, PersonWithDisabilityResource ) {
    $scope.disabled = false;
    $scope.$location = $location;
    $scope.personWithDisability = $scope.personWithDisability || {};
    

    $scope.save = function() {
        var successCallback = function(data,responseHeaders){
            var id = locationParser(responseHeaders);
            flash.setMessage({'type':'success','text':'The personWithDisability was created successfully.'});
            $location.path('/PersonWithDisabilities');
        };
        var errorCallback = function(response) {
            if(response && response.data) {
                flash.setMessage({'type': 'error', 'text': response.data.message || response.data}, true);
            } else {
                flash.setMessage({'type': 'error', 'text': 'Something broke. Retry, or cancel and start afresh.'}, true);
            }
        };
        PersonWithDisabilityResource.save($scope.personWithDisability, successCallback, errorCallback);
    };
    
    $scope.cancel = function() {
        $location.path("/PersonWithDisabilities");
    };
});