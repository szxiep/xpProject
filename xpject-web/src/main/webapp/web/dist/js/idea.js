var idea = new Vue({
    el: "#idea",
    data: {
        left: {
            inform: {
                text: "在线支持",
                link: ""
            },
        },
        form: {
            name: "",
            phone: "",
            email: "",
            content: "",
        },
        verify: {
            name: "请填写您的姓名",
            phone: "请填写您的手机号码",
            email: "请填写您的电子邮箱地址",
            success: [
                false,
                false,
                false
            ]
        }
    },
    methods: {
        int: function (params) {
            this.verify.name = "您的姓名输入有误";
            this.verify.phone = "您的手机号码输入有误";
            this.verify.email = "您的邮箱输入有误";
            for (let i = 0; i < this.verify.success.length; i++) {
                this.verify.success[i] = false;
            }

            if (this.form.phone.length > 11) {
                this.form.phone = this.form.phone.substring(0, 11)
            }
            if (this.form.email.length > 35) {
                this.form.email = this.form.email.substring(0, 35)
            }
            if (this.form.content.length > 300) {
                this.form.content = this.form.content.substring(0, 300)
            }
            console.log()
            if (!/[^\u4e00-\u9fa5*A-z*]/.exec(this.form.name) && this.form.name.length >= 2) {
                this.verify.success[0] = true;
                this.verify.name = "姓名输入正确";
                // console.log("姓名输入正确");
            }
            if (/^[1][3,4,5,7,8][0-9]{9}$/.test(this.form.phone)) {
                this.verify.success[1] = true;
                this.verify.phone = "手机号码输入正确";
                // console.log("号码正确");
            }
            let regEmail = new RegExp("^[a-z0-9]+([._\\-]*[a-z0-9])*@([a-z0-9]+[-a-z0-9]*[a-z0-9]+.){1,63}[a-z0-9]+$");
            if (regEmail.test(this.form.email)) {
                this.verify.success[2] = true;
                this.verify.email = "邮箱输入正确";
            }

        },
        submit: function (params) {
            if (this.form.name == "") {
                return alert("姓名不能为空");
            }
            if (this.form.phone == "") {
                return alert("电话号码不能为空");
            }
            if (this.form.email == "") {
                return alert("邮箱不能为空");
            }
            if (!this.verify.success[0] || !this.verify.success[1] || !this.verify.success[2]) {
                return alert("请输入正确信息");
            }
            let ip = "192.168.0.138/xpject-web"
            $.ajax({
                url: "http://" + ip + "/admin/sys/signup/add",
                data: idea.form,
                success: function (data) {
                    // console.log(data);
                    if (data.status == 1) {
                        console.log(data.msg);
                        window.location.href="";
                        return alert("提交成功!");
                    } else {
                        alert(data.msg);
                    }
                },
            });
        }
    }
});
// $.ajax({
//     url: "http://47.106.123.115/xpject-web/admin/sys/signup/seleList",
//     // data: "",
//     success: function (data) {
//         console.log(data);
//         if (data.status == 0) {
//             return console.log(data.msg);
//         }

//     },
// });
