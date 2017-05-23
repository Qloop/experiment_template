<template>
  <div class="detail-container">
    <el-button class="hidden-print" type="primary" v-on:click="print">打印</el-button>
    <div class="header">
      <h1>123{{data.title}}</h1>
      <div class="student-msg">
        <h2>班级：{{data.stuClass}}</h2>
        <h2>姓名：{{data.stuName}}</h2>
        <h2>学号：{{data.stuId}}</h2>
      </div>
    </div>
    <div class="box">
      <h2 class="page-next">实验目的</h2>
      <p>{{data.goalRept}}</p>
    </div>
    <div class="box">
      <h2>实验原理</h2>
      <p>{{data.theoryRept}}</p>
    </div>
    <div class="box">
      <h2>实验器材</h2>
      <p>{{data.equipment}}</p>
    </div>
    <div class="box">
      <h2>实验要求</h2>
      <p>{{data.demand}}</p>
    </div>
    <div class="box">
      <h2>注意事项</h2>
      <p>{{data.warning}}</p>
    </div>
    <div class="box">
      <h2>实验数据记录与处理</h2>
      <p>{{data.data}}</p>
    </div>
    <div class="box">
      <h2>思考与讨论</h2>
      <p>{{data.thinking}}</p>
    </div>
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

  @media print {
    .hidden-print {
      display: none !important;
    }
  }

  .detail-container {
    margin: 15px 20px;

    .header {
      text-align: center;
      margin-top: 350px;

      .student-msg {
        margin-top: 30px;
        padding: 0 10%;
        margin-left: 150px;
        text-align: left;
        line-height: 40px;
      }
    }

    .box {

      p {
        border: 1px solid black;
        padding: 10px;
      }
    }

    .page-next {
      page-break-before: always;
    }

  }
</style>
