<template>
  <div class="detail-container">
    <el-button type="primary" v-on:click="print">打印</el-button>
    <h1>{{data.title}}</h1>
    <h2>实验目的</h2>
    <p>{{data.goalRept}}</p>
    <h2>实验原理</h2>
    <p>{{data.theoryRept}}</p>
    <h2>实验器材</h2>
    <p>{{data.equipment}}</p>
    <h2>实验要求</h2>
    <p>{{data.demand}}</p>
    <h2>注意事项</h2>
    <p>{{data.warning}}</p>
    <h2>实验数据记录与处理</h2>
    <p>{{data.data}}</p>
    <h2>思考与讨论</h2>
    <p>{{data.thinking}}</p>
  </div>
</template>

<script>
  import API from '../../config/request';
  export default {
    data() {
      return {
        data: {}
      }
    },
    created() {
      this.loadData()
    },
    methods: {
      print() {
        window.print();
      },
      loadData() {
        this.$http.get(API.teacherWatch(this.$route.params.tplid, this.$route.params.stuid)).then(
          (res) => {
            console.log(res.data);
            this.data = res.data;
          }
        )
      }
    }
  }
</script>

<style lang="less">
  .detail-container {

  }
</style>
