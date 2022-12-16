<template>
    <footer>
      <div class="container pt-5">
        <div class="text-center py-5">
          <img id="logo" src="../assets/cig.png" />
        </div>
      </div>
    </footer>
  </template>
  
  <script>
  export default {
    // eslint-disable-next-line vue/multi-word-component-names
    name : "Footer"
  }
  </script>
  
  <style>
  footer {
    margin-top : 100px;
    background-color:black;
    font-size:16px;
    font-family: 'Roboto', sans-serif;
  }
  
  #logo {
    width: 150px;
  }
</style>
  