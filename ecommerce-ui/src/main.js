import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import swal from 'sweetalert';


createApp(App).use(router).mount('#app')
window.axios = require('axios')
window.Swal = swal