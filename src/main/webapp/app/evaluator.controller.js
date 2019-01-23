(function() {
  angular
    .module('app')
    .controller('EvaluatorController', EvaluatorController);

  EvaluatorController.$inject = ['evaluatorService'];
  
  function EvaluatorController(evaluatorService) {
    var vm = this;
    vm.evaluate = _evaluate;
    
    _init();
    
    function _init() {
      vm.development = false;
      vm.request = {};
      vm.response = {};
      vm.request.password = '';

      vm.badges = {};
      vm.badges.TOO_SHORT   = {description: 'Muito curta', classes: 'badge badge-danger'};
      vm.badges.VERY_WEAK   = {description: 'Muito fraca', classes: 'badge badge-danger'};
      vm.badges.WEAK        = {description: 'Fraca', classes: 'badge badge-warning'};
      vm.badges.GOOD        = {description: 'Boa', classes: 'badge badge-primary'};
      vm.badges.STRONG      = {description: 'Forte', classes: 'badge badge-info'};
      vm.badges.VERY_STRONG = {description: 'Muito forte', classes: 'badge badge-success'};
      _evaluate();
    }
    
    function _evaluate() {
      if (vm.request.password === '') {
        vm.response.complexity = vm.badges.TOO_SHORT;
        vm.response.rules = [];
        vm.response.score = 0;
        vm.response.error = '';
        return;
      }
      
      evaluatorService.evaluate(vm.request).then(function (response) {
        vm.response.complexity = vm.badges[response.data.complexity];
        vm.response.score = response.data.score;
        vm.response.rules = response.data.rules;
        vm.response.error = '';
      }, function (response) {
        vm.response.error = response.data;
      });
    }
  }
})();