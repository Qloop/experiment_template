<template>
  <div class="detail-container">
sds
  </div>
</template>

<script>
  import API from '../../config/request';
  export default {
    created() {

    },
    methods: {
      loadData() {
        this.$http.get(API.teacherWatch(this.$route.params.stuid, this.$route.params.tplid)).then(
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
