<template>
  <div class="report-container">
    <h1>实验报告生成系统</h1>

    <h2>实验：{{reportData.title}}</h2>
    <h2>实验目的</h2>
    <v-template component-id="test" :text="reportData.goal" :question-number="1"></v-template>
    <h2>实验原理</h2>
    <p>{{reportData.theory}}</p>
    <h2>实验器材</h2>
    <p>{{reportData.equipment}}</p>
    <h2>实验要求</h2>
    <p>{{reportData.demand}}</p>
    <h2>注意事项</h2>
    <p>{{reportData.warning}}</p>
    <h2>实验数据记录和处理</h2>
    <p>{{reportData.data}}</p>
    <h2>思考与讨论</h2>

  </div>
</template>

<script>
  import API from '../../config/request'
  import Template from './questionTpl';
  export default {
    data() {
      return {
        reportData: {
          goal: ''
        }
      }
    },
    created() {
      let reportId = this.$route.params.id;
      this.$http.get(API.display(reportId)).then(
        (res) => {
          console.log(res.data);
          this.reportData = res.data;

        }
      )
    },
    components: {
      vTemplate: Template
    }
  }
</script>

<style lang="less" scoped>
  .report-container {
    padding: 10px;

    h1 {
      text-align: center;
      font-size: 22px;
    }

    h2 {
      font-size: 18px;
    }
  }
</style>
