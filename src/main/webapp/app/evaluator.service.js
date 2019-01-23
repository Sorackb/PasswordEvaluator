(function() {
  angular
    .module('app')
    .factory('evaluatorService', evaluatorService);

  evaluatorService.$inject = ['$http'];
  
  function evaluatorService($http) {
    let service = {};
    
    service.evaluate = _evaluate;
    
    function _evaluate(data) {
      return $http.post('./services', data);
    }
    
    return service;
  }
})();