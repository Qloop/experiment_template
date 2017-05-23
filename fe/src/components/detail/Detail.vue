<template>
  <div class="detail-container">

  </div>
</template>

<script>
  import API from '../../config/request';
  export default {
    created() {
      this.loadData()
    },
    methods: {
      loadData() {
        this.$http.get(API.teacherWatch(this.$route.params.tplid, this.$route.params.stuid)).then(
          (res) => {
            console.log(res.data);
          }
        )
      }
    }
  }
</script>

<style>

</style>
