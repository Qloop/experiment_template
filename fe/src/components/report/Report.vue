<template>
  <div class="report-container">
    <h1>{{}}</h1>
    <h1>实验目的</h1>
  </div>
</template>

<script>
  import API from '../../config/request'
  export default {
    data() {
      return {
        reportData: {}
      }
    },
    created() {
      let reportId = this.$route.params.id;
      this.$http.get(API.display(reportId)).then(
        (res) => {
            console.log(res.data);
        }
      )
    }
  }
</script>

<style>

</style>
