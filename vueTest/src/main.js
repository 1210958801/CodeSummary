// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import axios from 'axios'

Vue.config.productionTip = false
Vue.prototype.Axios = Axios;
Vue.prototype.Axios.defaults.headers = {
  'Content-Type': 'application/json'
};

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: {
    App,
    axios
  },
  template: '<App/>'
})
