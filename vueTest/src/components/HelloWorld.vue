<template>
  <div class="hello">
    <h1>{{ msg }}</h1>
    <h2>Essential Links</h2>
    <button @click="downLoad()">下载</button>
  </div>
</template>

<script>
  export default {
    name: 'HelloWorld',
    data() {
      return {
        msg: 'Welcome to Your Vue.js App'
      }
    },
    methods: {
      downLoad() {
        this.Axios({
          method: 'post',
          url: 'http://192.168.101.90:8900/nz/promag/dldExcel',
          data: {
            agricName: ["12"]
          }
        }).then(res => {
          var data = res.data;
          if (data.code == '000') {} else {
            this.$alert(data.msg || '请求失败...', '错误提示', {
              cofirmButtonText: '确定',
              type: 'error'
            })
          }
        })
      }
    }
  }
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
  h1,
  h2 {
    font-weight: normal;
  }

  ul {
    list-style-type: none;
    padding: 0;
  }

  li {
    display: inline-block;
    margin: 0 10px;
  }

  a {
    color: #42b983;
  }
</style>
