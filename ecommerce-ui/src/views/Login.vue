<template>
    <div class="container">
      <div class="row">
        <div class="col-12 justify-content-center d-flex flex-row pt-5">
          <div id="signin-div" class="flex-item border">
            <h2 class="pt-4 pl-4">Log-In</h2>
            <form @submit="login" class="pt-4 pl-4 pr-4">
              <div class="form-group">
                <label>Username</label>
                <input type="userName" class="form-control" v-model="userName" required>
              </div>
              <div class="form-group">
                <label>Password</label>
                <input type="password" class="form-control" v-model="password" required>
              </div>
              <button type="submit" class="btn btn-primary mt-2 py-0">
                Log-In
                <div v-if="loading" class="spinner-border spinner-border-sm" role="status">
                  <span class="sr-only">Loading...</span>
                </div>
              </button>
            </form>
            <hr>
            <small class="form-text text-muted pt-2 pl-4 text-center">New to Site?</small>
            <p class="text-center">
              <router-link :to="{name: 'Register'}" class="btn btn-dark text-center mx-auto px-5 py-1 mb-2">Create New Account</router-link>
            </p>
          </div>
        </div>
      </div>
    </div>
  </template>
  
  <script>
const axios = require('axios')
import swal from 'sweetalert';
export default {
  // eslint-disable-next-line vue/multi-word-component-names
  name: 'Login',
  props : [ "baseURL"],
  data() {
    return {
      userName: null,
      password: null,
      loading: null
    }
  },
  methods : {
    async login(e) {
      e.preventDefault();
    
      this.loading = true;
      const user = {
        userName: this.userName,
        password: this.password
      }
  
      await axios({
        method: 'post',
        url: this.baseURL + "user/signin",
        data : JSON.stringify(user),
        headers: {
          'Content-Type': 'application/json'
        }
      })
      .then(res => {
        
        localStorage.setItem('userId', res.data.userId);
        localStorage.setItem('userName', res.data.userName);
       
        this.$router.push({name:'Home'});
        swal({
          text: "Login successful. Please continue",
          icon: "success"
        });
      })
      .catch(err => {
        
        swal({
          text: "Unable to Log you in!",
          icon: "error",
          closeOnClickOutside: false,
        });
        console.log(err);
      })
      .finally(() => {
        
        this.loading = false;
      })
    }
  },
  mounted() {
    this.loading = false;
  }
}
</script>
  
  <style scoped>
  .btn-dark {
    background-color: #e7e9ec;
    color: #000;
    font-size: smaller;
    border-radius: 0;
    border-color: #adb1b8 #a2a6ac #a2a6ac;
  }
  
  .btn-primary {
    background-color: #f0c14b;
    color: black;
    border-color: #a88734 #9c7e31 #846a29;
    border-radius: 0;
  }
  
  #logo {
    width: 150px;
  }
  
  @media only screen and (min-width: 992px) {
    #signin-div {
      width: 40%;
    }
  }
  
  
  </style>
  