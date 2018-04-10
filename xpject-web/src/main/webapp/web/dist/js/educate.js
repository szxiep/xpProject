var educate = new Vue({
    el: "#educate",
    data: {
        left: {
            graduate: {
                text: "研究生",
                link: "educate.html"
            },
            webucation: {
                text: "网络教育",
                link: "new-flash.html"
            },
            enterprise: {
                text: "企业培训",
                link: "new-media.html"
            },
            login: {
                text: "网上报名",
                link: "educate-login.html"
            }
        },
        right: {
            graduate: {
                show: {

                },
                list: [
                    {
                        title: "网络教育2017年秋季重考报名通知",
                        time: "2018-04-05",
                        link: "new-inform1.html",
                    },
                    {
                        title: "网络教育(专本科）2017年春季课程期末考试安排",
                        time: "2018-04-05",
                        link: "",
                    },
                    {
                        title: "转：上海交通大学2017年秋季网络教育（专本科）报名时间截止的通知",
                        time: "2018-04-05",
                        link: "",
                    },
                    {
                        title: "关于上海交通大学网络教育2017学年春季学期入学考试通知",
                        time: "2018-04-05",
                        link: "",
                    },
                    {
                        title: "研究生院关于2016-2017学年春季学期研究生注册和上课的通知",
                        time: "2018-04-05",
                        link: "",
                    }
                ]
            }
        },
        login: {
            form: {
                name: "",
                sex: "0",
                // 报考类别
                fortype: "",
                // 报考专业
                forprofession: "",
                phone: "",
                email: "",
                content: "",
            },
            verify: {
                name: "请填写您的姓名",
                sex: "请选择您的性别",
                fortype: "请填写您的报考类别",
                forprofession: "请填写您的报考专业",
                phone: "请填写您的手机号码",
                email: "请填写您的电子邮箱地址",
                success: [
                    false,
                    false,
                    false,
                ]
            }
        },
        sex_select: {
            man: "educate-sex-sele educate-sex-option",
            woman: "educate-sex-sele",
            clsNameOn: "educate-sex-sele educate-sex-option",
            clsName: "educate-sex-sele",
        },
        expertSorts: [
            { text: "专业1" },
            { text: "专业2" },
            { text: "专业3" },
            { text: "专业4" },
            { text: "专业5" },
            { text: "专业6" },
            { text: "专业7" },
        ]
    },
    methods: {
        sex_sele: function (params) {
            if (params.toElement.innerText.trim() == "男") {
                if (this.login.sex != "0") {
                    this.login.sex = "0";
                    this.sex_select.man = this.sex_select.clsNameOn;
                    this.sex_select.woman = this.sex_select.clsName;
                }
            }
            if (params.toElement.innerText.trim() == "女") {
                if (this.login.sex != "1") {
                    this.login.sex = "1";
                    this.sex_select.man = this.sex_select.clsName;
                    this.sex_select.woman = this.sex_select.clsNameOn;
                }
            }
            console.log(this.login.sex);
            // console.log(params.toElement.innerText.trim())
        },
        request: function (params) {

        },
        int: function (params) {
            // console.log(params.srcElement.id)
            if (params.srcElement.id == "exampleFormControlInput1") {
                this.login.verify.name = "您的姓名输入有误";
            }
            if (params.srcElement.id == "exampleFormControlInput5") {
                this.login.verify.phone = "您的手机号码输入有误";
            }
            if (params.srcElement.id == "exampleFormControlInput6") {
                this.login.verify.email = "您的邮箱输入有误";
            }
            for (let i = 0; i < this.login.verify.success.length; i++) {
                this.login.verify.success[i] = false;
            }
            if (this.login.form.phone.length > 11) {
                this.login.form.phone = this.login.form.phone.substring(0, 11)
            }
            if (this.login.form.email.length > 35) {
                this.login.form.email = this.login.form.email.substring(0, 35)
            }
            if (this.login.form.content.length > 300) {
                this.login.form.content = this.login.form.content.substring(0, 300)
            }
            console.log()
            if (!/[^\u4e00-\u9fa5*A-z*]/.exec(this.login.form.name) && this.login.form.name.length >= 2) {
                this.login.verify.success[0] = true;
                this.login.verify.name = "姓名输入正确";
                // console.log("姓名输入正确");
            }
            if (/^[1][3,4,5,7,8][0-9]{9}$/.test(this.login.form.phone)) {
                this.login.verify.success[1] = true;
                this.login.verify.phone = "手机号码输入正确";
                // console.log("号码正确");
            }
            let regEmail = new RegExp("^[a-z0-9]+([._\\-]*[a-z0-9])*@([a-z0-9]+[-a-z0-9]*[a-z0-9]+.){1,63}[a-z0-9]+$");
            if (regEmail.test(this.login.form.email)) {
                this.login.verify.success[2] = true;
                this.login.verify.email = "邮箱输入正确";
            }

        },
        submit: function (params) {
            if (this.login.form.name == "") {
                return alert("姓名不能为空");
            }
            if (this.login.form.fortype == "") {
                return alert("报考类别不能为空");
            }
            if (this.login.form.forprofession == "") {
                return alert("报考专业不能为空");
            }
            if (this.login.form.phone == "") {
                return alert("电话号码不能为空");
            }
            if (this.login.form.email == "") {
                return alert("邮箱不能为空");
            }
            if (!this.login.verify.success[0] || !this.login.verify.success[1] || !this.login.verify.success[2]) {
                return alert("请输入正确信息");
            }
            $.ajax({
                url: `http://${PORT_IP}/admin/sys/signup/add`,
                data: educate.login.form,
                success: function (data) {
                    // console.log(data);
                    if (data.status == 1) {
                        console.log(data.msg);
                        window.location.href = "";
                        return alert("提交成功!");
                    } else {
                        alert(data.msg);
                    }
                },
            });
        },
        reset: function (param) {
            this.login.form = {
                name: "",
                sex: "0",
                // 报考类别
                fortype: "",
                // 报考专业
                forprofession: "",
                phone: "",
                email: "",
                content: "",
            }
            this.login.verify = {
                name: "请填写您的姓名",
                sex: "请选择您的性别",
                fortype: "请填写您的报考类别",
                forprofession: "请填写您的报考专业",
                phone: "请填写您的手机号码",
                email: "请填写您的电子邮箱地址",
                success: [
                    false,
                    false,
                    false,
                ]
            }
        },
    },
});
// 接口还是有问题
// console.log(`http://${PORT_IP}/admin/sys/signup/add`)
// $.ajax({
//     url:`http://${PORT_IP}/admin/sys/signup/add`,
//     // data:"",
//     success: function (data) {     
//         console.log(data);
//         // if (data.status==0) {
//         //     return console.log(data.msg);
//         // }
//     },
// });
