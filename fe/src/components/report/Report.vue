<template>
  <div class="report-container">

    <h1>实验：{{reportData.title}}</h1>

    <el-form class="base-info" ref="form" :model="form" label-width="40px">
      <el-form-item label="班级">
        <el-input v-model="form.class"></el-input>
      </el-form-item>
      <el-form-item label="姓名">
        <el-input v-model="form.name"></el-input>
      </el-form-item>
      <el-form-item label="学号">
        <el-input v-model="form.number"></el-input>
      </el-form-item>
    </el-form>

    <h2>实验目的</h2>
    <v-template component-id="goal" :text="reportData.goal"
                :question-number="parseInt(reportData.goalSPCount)"></v-template>
    <h2>实验原理</h2>
    <v-template component-id="theory" :text="reportData.theory"
                :question-number="parseInt(reportData.theorySPCount)"></v-template>
    <h2>实验器材</h2>
    <v-template component-id="equipment" :text="reportData.equipment"
                :question-number="parseInt(reportData.equipmentSPCount)"></v-template>
    <h2>实验要求</h2>
    <v-template component-id="demand" :text="reportData.demand"
                :question-number="parseInt(reportData.demandSPCount)"></v-template>
    <h2>注意事项</h2>
    <v-template component-id="warning" :text="reportData.warning"
                :question-number="parseInt(reportData.warningSPCount)"></v-template>
    <h2>实验数据记录和处理</h2>
    <v-template component-id="data" :text="reportData.data"
                :question-number="parseInt(reportData.dataSPCount)"></v-template>

    <el-upload
      class="upload-demo"
      action="http://118.89.112.50:8082/submit_imgs"
      :data="imgUpload"
      name="imgs"
      :on-success="handleSuccess"
      :on-remove="handleFileRemove"
      >
      <el-button size="small" type="primary">点击上传</el-button>
      <div slot="tip" class="el-upload__tip">只能上传jpg/png文件，且不超过500kb</div>
    </el-upload>


    <h2>思考与讨论</h2>
    <el-input type="textarea" :rows="10" v-model="form.thinking"></el-input>

    <el-button class="submit-btn" type="primary" v-on:click="submit">提交报告</el-button>

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
        },
        form: {
          name: '',
          class: '',
          number: ''
        },
        fileList: [],
        imgUpload: {
          templateId: 0
        }
      }
    },
    created() {
      let reportId = this.$route.params.id;
      this.imgUpload.templateId = reportId;
      this.$http.get(API.display(reportId)).then(
        (res) => {
          console.log(res.data);
          this.reportData = res.data;
        }
      )
    },
    methods: {
      getMessage() {
        let goalRept = document.getElementById('goal').children[0].innerHTML;
        let theoryRept = document.getElementById('theory').children[0].innerHTML;
        let equipmentRept = document.getElementById('equipment').children[0].innerHTML;
        let demandRept = document.getElementById('demand').children[0].innerHTML;
        let warningRept = document.getElementById('warning').children[0].innerHTML;
        let dataRept = document.getElementById('data').children[0].innerHTML;
        return {goalRept, theoryRept, equipmentRept, demandRept, warningRept, dataRept}
      },
      submit() {
        let postData = this.getMessage();
        postData.stuName = this.form.name;
        postData.stuClass = this.form.class;
        postData.stuId = this.form.number;
        postData.thinkingRept = this.form.thinking;
        postData.templateId = this.$route.params.id;
        postData.imgs = JSON.stringify(this.fileList);

        this.$http.post(API.submitReport, postData).then(
          (res) => {
            if (res.data.result === 0) {
              this.$notify({
                title: '提交成功',
                type: 'success'
              });
            }
          }
        )
      },
      handleSuccess(res) {
        this.fileList.push(res.urls);
      },
      handleFileRemove(file) {
        let index = this.fileList.indexOf(file.response.urls);
        this.fileList.splice(index, 1);
      }
    },
    components: {
      vTemplate: Template
    }
  }
</script>

<style lang="less">
  .report-container {
    padding: 10px;

    .submit-btn {
      margin-top: 10px;
      width: 100%;
      text-align: center;
    }

    h1 {
      text-align: center;
      font-size: 22px;
    }

    h2 {
      font-size: 18px;
      margin: 20px 0 0 0;
    }

    .base-info {
      margin: 10px 10%;
    }

    .input-area {
      /*text-align: center;*/
      margin: 3px;

      input {
        box-sizing: border-box;
        text-align: center;
        border: solid #20A0FF 1px;
        outline: none;
        border-radius: 4px;
        width: 45%;
        padding: 1%;
        margin: .5% 2%;
      }
    }
  }
</style>
