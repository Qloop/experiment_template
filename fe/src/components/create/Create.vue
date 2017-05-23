<template>
  <div class="create-container">
    <top-nav activeIndex="1"></top-nav>
    <div class="form-area">
      <div class="title">
        <h1>实验报告生成系统</h1>
        <p v-pre>请在此处创建实验报告模板，请先仔细阅读要求。在文本中插入让学生填写的空请按如下方法插入，以" {{question0}}"的形式留空，必须是question打头，后跟一数字，从0开始数。例如：本次实验的目的是{{question0}}，通过{{question1}}方法，得到{{question3}}结果。<br/>
          仅有实验目的/实验原理/实验器材/实验要求/注意事项/实验数据记录和处理可以留下待学生填写的空，每部分的{{question}}都从0开始单独算。
        </p>
        <p class="link"><span v-on:click="toExample">样例</span></p>
      </div>
      <el-form ref="form" :model="form" label-width="80px">

        <el-form-item label="创建者ID">
          <el-input v-model="form.authorId" placeholder="输入您的工号，作为查阅您创建的模板的凭据"></el-input>
        </el-form-item>

        <el-form-item label="实验标题">
          <el-input v-model="form.title" placeholder="输入实验标题"></el-input>
        </el-form-item>

        <div class="form-group">
          <el-form-item label="实验目的">
            <el-input type="textarea" v-model="form.goal"></el-input>
          </el-form-item>
          <el-form-item label="问题数量">
            <el-input type="number" v-model="form.goalSPCount"></el-input>
          </el-form-item>
        </div>

        <div class="form-group">
          <el-form-item label="实验原理">
            <el-input type="textarea" v-model="form.theory"></el-input>
          </el-form-item>
          <el-form-item label="问题数量">
            <el-input type="number" v-model="form.theorySPCount"></el-input>
          </el-form-item>
        </div>

        <div class="form-group">
          <el-form-item label="实验器材">
            <el-input type="textarea" v-model="form.equipment"></el-input>
          </el-form-item>
          <el-form-item label="问题数量">
            <el-input type="number" v-model="form.equipmentSPCount"></el-input>
          </el-form-item>
        </div>

        <div class="form-group">
          <el-form-item label="实验要求">
            <el-input type="textarea" v-model="form.demand"></el-input>
          </el-form-item>
          <el-form-item label="问题数量">
            <el-input type="number" v-model="form.demandSPCount"></el-input>
          </el-form-item>
        </div>

        <div class="form-group">
          <el-form-item label="注意事项">
            <el-input type="textarea" v-model="form.warning"></el-input>
          </el-form-item>
          <el-form-item label="问题数量">
            <el-input type="number" v-model="form.warningSPCount"></el-input>
          </el-form-item>
        </div>

        <div class="form-group">
          <el-form-item label="实验数据记录和处理">
            <el-input type="textarea" v-model="form.data"></el-input>
          </el-form-item>
          <el-form-item label="问题数量">
            <el-input type="number" v-model="form.dataSPCount"></el-input>
          </el-form-item>
        </div>

        <el-form-item>
          <el-button type="primary" @click="onSubmit">立即创建</el-button>
          <el-button>取消</el-button>
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>

<script>
  import API from '../../config/request';
  import TopNav from '../common/TopNav.vue';
  export default {
    data() {
      return {
        form: {
          authorId: '',
          title: '',
          goal: '',
          goalSPCount: 0,
          theory: '',
          theorySPCount: 0,
          equipment: '',
          equipmentSPCount: 0,
          demand: '',
          demandSPCount: 0,
          warning: '',
          warningSPCount: 0,
          data: '',
          dataSPCount: 0,
          thinking: ''
        }
      }
    },
    methods: {
      onSubmit() {
//        let postData = JSON.stringify(this.form);
        let postData = this.form;
        console.log(postData);
        this.$http.post(API.create, postData).then(
          (res) => {
            console.log(res);
          }
        )
      },
      toExample() {
        this.$router.push('/example');
      }
    },
    components: {
      TopNav
    }
  }
</script>

<style lang="less" scoped>
  .create-container {

    .form-area {
      margin: 40px 15%;

      .title {
        margin: 30px;

        h1 {
          text-align: center;
        }

        .link {
          color: blue;
          text-decoration: underline;

          span {
            cursor: pointer;
          }
        }
      }

      .form-group {
        border: 2px solid blue;
        padding: 20px 20px 0 0;
        margin: 10px 0;
      }
    }
  }
</style>
