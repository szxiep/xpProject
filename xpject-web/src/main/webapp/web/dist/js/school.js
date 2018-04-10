var school = new Vue({
    el: "#school",
    data: {
        left: {
            intro: {
                text: "研究院介绍",
                link: "school.html"
            },
            set: {
                text: "机构设置",
                link: "school-set.html"
            },
            history: {
                text: "校史资料",
                link: "school-history.html"
            }
        },
        intro: {
            img: "dist/images/school/view.jpg",
            text:
                "广东省华南信息化教育研究院是一个从事将教育理论，教育技术信息化应用和推广的非营利性社会组织机构。研究院旨在通过对全球先进的教育信息化应用的研究，将信息化技术融入传统教育，家庭教育等方面。协同全国众多信息化教育专家、学校和相关社会机构开展实践。本院业务领域主要有教育信息化应用研究与开发、教育信息化硬件设备生产制备技术开发、校园网络的建设与研究、家庭教育信息化在线服务等。现已开设信息化教育研究室、家庭教育研究室、心理教育研究室、基础教育研究室等多个研究科室。2013年起，研究院与中央电化教育馆、云南省教育厅、中科院、江苏教育厅、深圳电教馆、深圳市教育发展基金会等机构建立战略合作关系，成功开展多项信息化教育实践，正逐渐成为学校、家庭、社区共同教育的优秀服务机构并推动校园信息化建设，促进我国教育信息化学科、事业和产业的全面发展。"

        },
        set: {
            img: "dist/images/school/view.jpg",
            text:
                "华南信息化教育研究院于2000年8月经深圳市事业单位登记管理局批准成立，实行理事会领导下的院长负责制。研究院下设综合办公室、科研办公室、培训中心、重点实验室和工程研究中心。"

        },
        history: {
            text: [
                {
                    p: "学校现有本科专业64个，涵盖经济学、法学、文学、理学、工学、农学、医学、管理学和艺术等九个学科门类；新世纪以来获47项高等教育国家级教学成果奖（其中31项独立完成）；拥有国家级实验教学示范中心6个，国家级虚拟仿真实验教学示范中心3个，上海市实验教学示范中心10个；有国家级教学团队8个，上海市教学团队15个；有国家级教学名师8人，上海市教学名师36人；有国家级精品课程46门，国家级视频公开课13门，国家级精品资源共享课程23门，上海市精品课程162门；有国家级双语示范课程7门，上海高校示范性全英语课程14门。学校荣获国家首批“双创示范基地”，成立学生创新中心。"
                },
                {
                    p: "学校现有一级学科博士学位授权点38个，覆盖经济学、法学、文学、理学、工学、农学、医学、管理学等8个学科门类；一级学科硕士学位授权点56个，覆盖12个学科门类；博士专业学位授权点3个；硕士专业学位授权点23个；35个博士后流动站；1个国家实验室（筹），1个国家重大科技基础设施，8个国家重点（级）实验室，1个国家级科研机构，5个国家工程研究中心，2个国家工程实验室，1个国家级研发中心，1个国防重点学科实验室，3个国家协同创新中心，1个国际联合实验室，15个教育部重点实验室，5个卫生部重点实验室，1个农业部重点实验室，31个上海市重点实验室，5个教育部工程研究中心，5个上海市工程技术研究中心，4个上海市功能型平台，1个国家社科基金决策咨询点，5个上海市哲学社会科学创新研究基地，3个上海市高校智库，4个上海市人民政府决策咨询研究基地（专家工作室），2个上海市软科学基地，1个教育部高等学校软科学研究基地,3个世界卫生组织合作中心，1个国家技术转移中心和1个国家大学科技园。目前，正在建设面向世界基础科学前沿和国家战略需求的研究机构，如李政道研究所、中国城市治理研究院、中国质量发展研究院等。"
                },
                {
                    p: "拥有“暗物质探索研究”“捕获马约拉纳费米子”“第二代高温超导带材制造” “量子信息存储” “富营养化初期湖泊面源污染入湖河道流域治理成套技术” “4500米无人遥控潜水器（海马号）研制”“火箭发动机关键部件加工” “纳米材料全新力学现象” “合成光学活性无机材料” “DNA磷硫酰化修饰基因组图谱破译”“肾上腺肿瘤致病基因” “肾上腺和胰腺内分泌肿瘤医学基因组学” “胃癌发生机制” “生态系统镁研究” “生长素调控植物气孔发育” “水稻花器官发育”、“为治疗非酒精性脂肪肝寻找潜在新靶点”“治疗帕金森症天然产物”等一批重大研究成果。"
                },
                {
                    p: "上海交通大学深厚的文化底蕴，悠久的办学传统，奋发图强的发展历程，特别改革开放以来取得的巨大成就，为国内外所瞩目。这所英才辈出的百年学府正乘风扬帆，以传承文明、探求真理为使命，以振兴中华、造福人类为己任，向着“综合性、研究型、国际化”的世界一流大学目标奋进！"
                },

            ],
            time: "相关数据截至2016年12月31日"
        }
    }
})






























































// 学院概况的组织结构图
// 文字绘制不了,不了了之
// treeMap.prototype = {
//     line: function name(x1, y1, x2, y2) {
//         this.ctx.strokeStyle = "#888";
//         this.ctx.beginPath();
//         this.ctx.moveTo(x1, y1);
//         this.ctx.lineTo(x2, y2);
//         this.ctx.stroke();
//         this.ctx.closePath();
//     },
//     rect: function (x, y, w, h, color) {
//         //设定填充图形的样式  
//         this.ctx.fillStyle = color;
//         this.ctx.beginPath();
//         // //绘制图形
//         // context.fillRect(x,y,width,height);
//         this.ctx.fillRect(x, y, w, h);

//     },
//     rounded: function (xAxial, yAxial, w, h, color) {
//         var Point = function (x, y) {
//             return { x: x, y: y };
//         };
//         var rect = { x: xAxial, y: yAxial, width: w, height: h };
//         drawRoundedRect(rect, this.w / 24, this.ctx, color);
//         function drawRoundedRect(rect, r, ctx, color) {
//             var ptA = Point(rect.x + r, rect.y);
//             var ptB = Point(rect.x + rect.width, rect.y);
//             var ptC = Point(rect.x + rect.width, rect.y + rect.height);
//             var ptD = Point(rect.x, rect.y + rect.height);
//             var ptE = Point(rect.x, rect.y);
//             ctx.fillStyle = color;
//             ctx.strokeStyle = color;
//             ctx.beginPath();
//             ctx.moveTo(ptA.x, ptA.y);
//             ctx.arcTo(ptB.x, ptB.y, ptC.x, ptC.y, r);
//             ctx.arcTo(ptC.x, ptC.y, ptD.x, ptD.y, r);
//             ctx.arcTo(ptD.x, ptD.y, ptE.x, ptE.y, r);
//             ctx.arcTo(ptE.x, ptE.y, ptA.x, ptA.y, r);
//             ctx.fill();
//             ctx.closePath();
//             ctx.stroke();
//         }
//     },
//     font: function (color, font, text, x, y, w) {
//         this.ctx.fillStyle = color;
//         this.ctx.font = font;
//         this.ctx.fillText(text, x, y, w);
//     },
//     draw: function (params) {
//         var w = this.w;
//         let one = {
//             rounded: {
//                 x: w / 2 - w / 4 / 2,
//                 y: 0,
//                 w: w / 4,
//                 h: w / 4 / 3,
//                 color: "#154c59"
//             },
//             text: {
//                 color: "#fff",
//                 // font: "400 20px '微软雅黑'",
//                 text: {
//                     one: "理事会",
//                     two: "深圳研究院"
//                 },
//                 x: "",
//                 y: "",
//                 w: "",
//             },

//             line: {
//                 x1: "",
//                 y1: "",
//                 x2: "",
//                 y2: ""
//             }
//         };

//         // 文字宽度位置计算
//         one.text.x = one.rounded.x + one.rounded.w / 2.8;
//         one.text.y = one.rounded.y + one.rounded.h / 1.7;
//         one.text.w = one.rounded.w / 4;
//         one.text.font = "400 " + one.text.x / 15 + "px '微软雅黑'"
//         // 连接线长短位置计算
//         one.line.x1 = one.rounded.x + one.rounded.w / 2;
//         one.line.y1 = one.rounded.y + one.rounded.h;
//         one.line.x2 = one.line.x1;
//         one.line.y2 = one.rounded.y + one.rounded.h + one.rounded.h / 3;

//         // console.log(one.line.x1, one.line.y1, one.line.x2, one.line.y2)
//         // 结构图一级标题框 内容 连接线 1
//         this.rounded(one.rounded.x, one.rounded.y, one.rounded.w, one.rounded.h, one.rounded.color);
//         this.font(one.text.color, one.text.font, one.text.text.one, one.text.x, one.text.y, one.text.w);
//         this.line(one.line.x1, one.line.y1, one.line.x2, one.line.y2);
//         // 结构图一级标题框 内容 连接线 2
//         this.rounded(one.rounded.x, one.rounded.y + one.line.y2, one.rounded.w, one.rounded.h, one.rounded.color);
//         this.font(one.text.color, one.text.font, one.text.text.two, one.text.x - one.text.w / 2.2, one.text.y + one.line.y2, one.text.w * 2);
//         this.line(one.line.x1, one.line.y1 + one.line.y2, one.line.x2, one.line.y2 * 2.2);
//         let two = {
//             rect: {
//                 x: {
//                     x1: one.line.x2 - w / 7 / 2 - w * 0.8 / 5 * 2,
//                     x2: one.line.x2 - w / 7 / 2 - w * 0.8 / 5 * 1,
//                     x3: one.line.x2 - w / 7 / 2 - w * 0.8 / 5 * 0,
//                     x4: one.line.x2 - w / 7 / 2 + w * 0.8 / 5 * 1,
//                     x5: one.line.x2 - w / 7 / 2 + w * 0.8 / 5 * 2,
//                 },
//                 y: one.line.y2 * 2.2,
//                 w: w / 7,
//                 h: w / 7 / 2,
//                 color: "#388c87"
//             },
//             text: {
//                 color: "#fff",
//                 font: "16px '微软雅黑'",
//                 text: {
//                     a: "理事会",
//                     b: "科研办",
//                     c: "基建办",
//                     d: "教育中心",
//                     e: "研发中心",
//                 },
//                 x: "",
//                 y: "",
//                 w: "",
//             },
//             line: {
//                 across: {
//                     x1: "",
//                     y1: one.line.y2 * 2,
//                     x2: "",
//                     y2: one.line.y2 * 2
//                 },
//                 a: {
//                     x1: "",
//                     y1: "",
//                     x2: "",
//                     y2: "",
//                 },
//                 b: {
//                     x: "",
//                 },
//                 c: {
//                     x: "",
//                 },
//                 d: {
//                     x: "",
//                 },
//                 add: {
//                     x1: "",
//                     y1: "",
//                     x2: "",
//                     y2: "",
//                 },

//             }
//         }

//         // 二级
//         // 横线
//         two.line.across.x1 = two.rect.x.x1 + two.rect.w / 2;
//         two.line.across.x2 = two.rect.x.x5 + two.rect.w / 2;
//         this.line(two.line.across.x1, two.line.across.y1, two.line.across.x2, two.line.across.y2);

//         // a线
//         two.line.a.x1 = two.line.across.x1;
//         two.line.a.y1 = two.line.across.y1;
//         two.line.a.x2 = two.line.across.x1;
//         two.line.a.y2 = two.rect.y;
//         this.line(two.line.a.x1, two.line.a.y1, two.line.a.x2, two.line.a.y2);
//         // b线
//         two.line.b.x = two.rect.x.x2 + two.rect.w / 2;
//         this.line(two.line.b.x, two.line.a.y1, two.line.b.x, two.line.a.y2);
//         // c线
//         two.line.c.x = two.rect.x.x4 + two.rect.w / 2;
//         this.line(two.line.c.x, two.line.a.y1, two.line.c.x, two.line.a.y2);
//         // d线
//         two.line.d.x = two.rect.x.x5 + two.rect.w / 2;
//         this.line(two.line.d.x, two.line.a.y1, two.line.d.x, two.line.a.y2);
//         // 5个框
//         this.rect(two.rect.x.x1, two.rect.y, two.rect.w, two.rect.h, two.rect.color);
//         this.rect(two.rect.x.x2, two.rect.y, two.rect.w, two.rect.h, two.rect.color);
//         this.rect(two.rect.x.x3, two.rect.y, two.rect.w, two.rect.h, two.rect.color);
//         this.rect(two.rect.x.x4, two.rect.y, two.rect.w, two.rect.h, two.rect.color);
//         this.rect(two.rect.x.x5, two.rect.y, two.rect.w, two.rect.h, two.rect.color);
//         // 5个文字
//         this.font(two.text.color, two.text.font, two.text.text.a, two.rect.x.x1 + two.rect.w / 3.1, two.rect.y + two.rect.h / 1.7, two.rect.w / 2);
//         this.font(two.text.color, two.text.font, two.text.text.b, two.rect.x.x2 + two.rect.w / 3.1, two.rect.y + two.rect.h / 1.7, two.rect.w / 2);
//         this.font(two.text.color, two.text.font, two.text.text.c, two.rect.x.x3 + two.rect.w / 3.1, two.rect.y + two.rect.h / 1.7, two.rect.w / 2);
//         this.font(two.text.color, two.text.font, two.text.text.d, two.rect.x.x4 + two.rect.w / 3.8, two.rect.y + two.rect.h / 1.7, two.rect.w / 2);
//         this.font(two.text.color, two.text.font, two.text.text.e, two.rect.x.x5 + two.rect.w / 3.8, two.rect.y + two.rect.h / 1.7, two.rect.w / 2);
//         // 延展线
//         two.line.add.x1 = two.line.d.x;
//         two.line.add.y1 = two.rect.y + two.rect.h;
//         two.line.add.x2 = two.line.d.x;
//         two.line.add.y2 = two.line.add.y1 + two.rect.h / 3.5;
//         this.line(two.line.add.x1, two.line.add.y1, two.line.add.x2, two.line.add.y2);

//         // this.line(50, 50, 50, 70);
//         let three = {
//             line: {
//                 across: {
//                     x1: "",
//                     y1: two.line.add.y2,
//                     x2: "",
//                     y2: two.line.add.y2
//                 },
//                 x1: {},
//                 y1: two.line.add.y2,
//                 x2: {},
//                 y2: "",
//             },
//             rect: {
//                 x: {
//                     x1: w * (0.025 + 0.108 * 0),
//                     x2: w * (0.025 + 0.108 * 1),
//                     x3: w * (0.025 + 0.108 * 2),
//                     x4: w * (0.025 + 0.108 * 3),
//                     x5: w * (0.025 + 0.108 * 4),
//                     x6: w * (0.025 + 0.108 * 5),
//                     x7: w * (0.025 + 0.108 * 6),
//                     x8: w * (0.025 + 0.108 * 7),
//                     x9: w * (0.025 + 0.108 * 8),
//                 },
//                 y: one.line.y2 * 2.2 + one.line.y2,
//                 w: w * 0.06,
//                 h: w * 0.06 * 3,
//                 color: "#67cac5"
//             },

//         }
//         // 第三级别
//         // 横线
//         three.line.across.x1 = three.rect.x.x1 + three.rect.w / 2;
//         three.line.across.x2 = three.rect.x.x9 + three.rect.w / 2;
//         this.line(three.line.across.x1, three.line.across.y1, three.line.across.x2, three.line.across.y2);
//         // 9根竖线 坐标
//         three.line.y2 = three.rect.y;
//         three.line.x1["a"] = three.rect.x.x1 + three.rect.w / 2;
//         three.line.x2["a"] = three.line.x1.a;
//         three.line.x1["b"] = three.rect.x.x2 + three.rect.w / 2;
//         three.line.x2["b"] = three.line.x1.b;
//         three.line.x1["c"] = three.rect.x.x3 + three.rect.w / 2;
//         three.line.x2["c"] = three.line.x1.c;
//         three.line.x1["d"] = three.rect.x.x4 + three.rect.w / 2;
//         three.line.x2["d"] = three.line.x1.d;
//         three.line.x1["e"] = three.rect.x.x5 + three.rect.w / 2;
//         three.line.x2["e"] = three.line.x1.e;
//         three.line.x1["f"] = three.rect.x.x6 + three.rect.w / 2;
//         three.line.x2["f"] = three.line.x1.f;
//         three.line.x1["g"] = three.rect.x.x7 + three.rect.w / 2;
//         three.line.x2["g"] = three.line.x1.g;
//         three.line.x1["h"] = three.rect.x.x8 + three.rect.w / 2;
//         three.line.x2["h"] = three.line.x1.h;
//         three.line.x1["i"] = three.rect.x.x9 + three.rect.w / 2;
//         three.line.x2["i"] = three.line.x1.i;
//         // 9根竖线
//         this.line(three.line.x1.a, three.line.y1, three.line.x2.a, three.line.y2);
//         this.line(three.line.x1.b, three.line.y1, three.line.x2.b, three.line.y2);
//         this.line(three.line.x1.c, three.line.y1, three.line.x2.c, three.line.y2);
//         this.line(three.line.x1.d, three.line.y1, three.line.x2.d, three.line.y2);
//         this.line(three.line.x1.e, three.line.y1, three.line.x2.e, three.line.y2);
//         this.line(three.line.x1.f, three.line.y1, three.line.x2.f, three.line.y2);
//         this.line(three.line.x1.g, three.line.y1, three.line.x2.g, three.line.y2);
//         this.line(three.line.x1.h, three.line.y1, three.line.x2.h, three.line.y2);
//         this.line(three.line.x1.i, three.line.y1, three.line.x2.i, three.line.y2);
//         // 9个框
//         this.rect(three.rect.x.x1, three.rect.y, three.rect.w, three.rect.h, three.rect.color);
//         this.rect(three.rect.x.x2, three.rect.y, three.rect.w, three.rect.h, three.rect.color);
//         this.rect(three.rect.x.x3, three.rect.y, three.rect.w, three.rect.h, three.rect.color);
//         this.rect(three.rect.x.x4, three.rect.y, three.rect.w, three.rect.h, three.rect.color);
//         this.rect(three.rect.x.x5, three.rect.y, three.rect.w, three.rect.h, three.rect.color);
//         this.rect(three.rect.x.x6, three.rect.y, three.rect.w, three.rect.h, three.rect.color);
//         this.rect(three.rect.x.x7, three.rect.y, three.rect.w, three.rect.h, three.rect.color);
//         this.rect(three.rect.x.x8, three.rect.y, three.rect.w, three.rect.h, three.rect.color);
//         this.rect(three.rect.x.x9, three.rect.y, three.rect.w, three.rect.h, three.rect.color);
//         // this.rounded(250, 70, 100, 50, "#ddd");
//         // this.font(three.text.color, three.text.font, three.text.text.e, three.rect.x.x1 + three.rect.w / 3.8, three.rect.y + three.rect.h / 1.7, three.rect.w / 2);
//     }
// }

// function treeMap(params) {
//     this.canvas = document.querySelector("#tree-map");
//     this.ctx = this.canvas.getContext("2d");
//     this.canvas.width = document.querySelector(".school-tree").offsetWidth;
//     this.canvas.height = 500;
//     this.w = this.canvas.width;
//     // console.log("构造函数", this.canvas.width)
// }
// var treeMap = new treeMap();
// treeMap.draw();


