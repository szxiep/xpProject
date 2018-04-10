var header_ = new Vue({
    el: "#header",
    data: {
        header_top_row: {
            justifyContent: "center",
        },
        // 顶部三张图片
        img: {
            left: {
                src: "dist/images/index/logo.png",
            },
            middle: {
                src: "dist/images/index/phone.png",
                class: "header_top_phone_img img-fluid img-light",
                link: "tel:0755-266551617"

            },
            right: {
                src: "dist/images/index/2code.jpg",
                class: "img-fluid float-left img-light",
            }
        },
        nav: [
            {
                link: "index.html",
                text: "首页",
                class: "",
            },
            {
                link: "school.html",
                text: "院概况",
                class: "",
            },
            {
                link: "news.html",
                text: "新闻资讯",
                class: "",
            },
            {
                link: "educate.html",
                text: "教育培训",
                class: "",
            },
            {
                link: "idea.html",
                text: "在线支持",
                class: "",
            },
            {
                link: "about.html",
                text: "联系我们",
                class: "",
            },
        ],
        navAdd: {
            school: {
                teacher: {
                    src: "dist/images/index/nav.jpg",
                    text: "学院教师风采",
                    time: "2012-11-11",
                    link: "?教师"
                },
                sort: [
                    {
                        p: "研究院介绍",
                        link: "school.html",
                    },
                    {
                        p: "机构设置",
                        link: "school-set.html",
                    },
                    {
                        p: "校史资料",
                        link: "school-history.html",
                    },
                    {
                        p: "联系我们",
                        link: "?4",
                    }
                ]
            },
            news: {
                teacher: {
                    src: "dist/images/index/nav.jpg",
                    text: "学院教师风采",
                    time: "2012-11-11",
                    link: "?教师"
                },
                sort: [
                    {
                        p: "通知公告",
                        link: "?1",
                    },
                    {
                        p: "要闻快讯",
                        link: "?2",
                    },
                    {
                        p: "媒体报道",
                        link: "?3",
                    },
                    {
                        p: "学生活动",
                        link: "?4",
                    }
                ]

            },
            educate: {
                teacher: {
                    src: "dist/images/index/nav.jpg",
                    text: "学院教师风采",
                    time: "2012-11-11",
                    link: "?教师"
                },
                sort: [
                    {
                        p: "研究生",
                        link: "?1",
                    },
                    {
                        p: "网络教育",
                        link: "?2",
                    },
                    {
                        p: "企业培训",
                        link: "?3",
                    },
                    {
                        p: "网上报名",
                        link: "?4",
                    },
                ],

            },
            message: {}
        },
        show: false,
    },
    methods: {
        // 查询网址,文件名
        query: function (params) {
            // location.href
            let filename = location.href;
            filename = filename.substr(filename.lastIndexOf("/") + 1);
            if (filename.indexOf("?") == -1) {
                judge(filename);
            }
            if (filename.indexOf("?") != -1) {
                filename = filename.substring(0, filename.indexOf("?"))
                judge(filename);
            }
            // 判断
            function judge(filename) {
                // let arrFile1 = header_.nav[1].link.split(".");
                let arrFile = [];
                let arrReg = [];
                let result = [];
                for (let i = 0; i < header_.nav.length; i++) {
                    arrFile[i] = header_.nav[i].link.split(".");
                    arrFile[i][1] = "." + arrFile[i][1];
                    arrReg[i] = new RegExp(arrFile[i][0] + "[\\s\\S]*" + arrFile[i][1]);
                    result[i] = arrReg[i].exec(filename);
                }
                // arrFile1[1] = "." + arrFile1[1];
                console.log(filename);
                console.log(!!result[0]);
                // 
                switch (true) {
                    case "":
                        header_.nav[0].class = "active";
                        console.log("filename+");
                        break;
                    // header_.nav[0].link
                    case !!result[0]:
                        header_.nav[0].class = "active";
                        break;
                    case !!result[1]:
                        header_.nav[1].class = "active";
                        break;
                    case !!result[2]:
                        header_.nav[2].class = "active";
                        break;
                    case !!result[3]:
                        header_.nav[3].class = "active";
                        break;
                    case !!result[4]:
                        header_.nav[4].class = "active";
                        break;
                    default:
                        break;
                }
            }
        },
        // 导航附加栏   鼠标移入事件
        enter: function (params) {
            // innerText
            // console.log(params)
            let text = params.toElement.innerText.trim();
            // let textarr = ["首页", "院概况", "新闻资讯", "教育培训", "在线支持", "联系我们"];
            switch (text) {
                // 鼠标移入  院概况
                case this.nav[1].text:
                    this.show = true;
                    this.navAdd.message = this.navAdd.school;
                    // console.log(this.navAdd.message);
                    break;
                // 鼠标移入  询问咨询
                case this.nav[2].text:
                    this.show = true;
                    this.navAdd.message = this.navAdd.news;
                    // console.log(this.navAdd.message);
                    break;
                // 鼠标移入  教育培训
                case this.nav[3].text:
                    this.show = true;
                    this.navAdd.message = this.navAdd.educate;
                    break;
                default:
                    break;
            }

        },
        // 导航附加栏   鼠标移出事件
        leave: function (params) {
            let leave_cls_name = params.toElement.className;
            if (leave_cls_name != "nav-append") {
                this.show = false;
            }
            console.log();

        },
    }
});
header_.query();

// 页脚高度和位置,
function footerHeight() {
    let h = "calc(" + $("footer").height() + "px " + "+ 5%)";
    // console.log(h)
    $(".home-index").css("paddingBottom", h);
    $("body").css("height", "auto");
    setTimeout(() => {
        let boxh = $("body").height();
        let newDom = document.createElement("div");
        newDom.style.position = "absolute";
        newDom.style.zIndex = "-1";
        newDom.style.height = "100vh";
        // newDom.style.property = {height:"100vh"};
        document.querySelector("body").appendChild(newDom);
        domh = newDom.offsetHeight;
        // console.log(boxh, newDom, domh)
        if (boxh <= domh) {
            $("body").css("height", domh, newDom);
        }
        document.querySelector("body").removeChild(newDom);
    }, 50);
}
footerHeight();
window.onresize = function () {
    footerHeight();
}

// console.log($("footer").height())
$('.carousel').carousel({
    interval: 3000,
    keyboard: true,
    ride: false,
    wrap: true
})

var footer_ = new Vue({
    el: "#footer",
    data: {
        links: [
            {
                href: "../",
                text: "网站地图",
                line: "\f | \f",
            },
            {
                href: "../",
                text: "友情链接",
                line: "\f | \f",
            },
            {
                href: "../",
                text: "法律声明",
            },
        ],
        text: {
            copyright: "华南信息化教育研究院 版权所有",
            address: "地址：深圳市南山区科技园南区虚拟大学园B202室",
            phone: "电话：0755-26551617",
            icp: "ICP：粤ICP备16087508号"
        },
        logo: {
            src: "dist/images/index/bottomLogo.png"
        }
    }

})




