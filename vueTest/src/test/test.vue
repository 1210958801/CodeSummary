<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title></title>
  <script src="https://unpkg.com/vue/dist/vue.js"/>
  <script>
      var app = new Vue({
          el: '#app1',
          data: {
              message: 'Hello Vue!'
          }
      })
  </script>
</head>
<body>
<div id="app1">
  {{ message }}
</div>
</body>
</html>
