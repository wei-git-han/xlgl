(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-f1d4846a","chunk-38e6ce36"],{"7faf":function(e,t,s){"use strict";s.r(t);var r=function(){var e=this,t=e.$createElement,s=e._self._c||t;return s("el-card",{staticStyle:{"margin-bottom":"20px"}},[s("div",{staticClass:"clearfix",attrs:{slot:"header"},slot:"header"},[s("span",[e._v("简介")])]),e._v(" "),s("div",{staticClass:"user-profile"},[s("div",{staticClass:"box-center"},[s("pan-thumb",{attrs:{image:e.user.avatar,height:"100px",width:"100px",hoverable:!1}},[s("div",[e._v("您好！")]),e._v("\n        "+e._s(e.user.name)+"\n      ")])],1),e._v(" "),s("div",{staticClass:"box-center"},[s("div",{staticClass:"user-name text-center"},[e._v(e._s(e.user.name))]),e._v(" "),s("div",{staticClass:"user-role text-center text-muted"},[e._v(e._s(e._f("uppercaseFirst")(e.user.role)))])])]),e._v(" "),s("div",{staticClass:"user-bio"},[s("div",{staticClass:"user-education user-bio-section"},[s("div",{staticClass:"user-bio-section-header"},[s("svg-icon",{attrs:{"icon-class":"education"}}),s("span",[e._v("教育经历")])],1),e._v(" "),s("div",{staticClass:"user-bio-section-body"},[s("div",{staticClass:"text-muted"},[e._v("\n          各项能力分布\n        ")])])]),e._v(" "),s("div",{staticClass:"user-skills user-bio-section"},[s("div",{staticClass:"user-bio-section-header"},[s("svg-icon",{attrs:{"icon-class":"skill"}}),s("span",[e._v("能力评分")])],1),e._v(" "),s("div",{staticClass:"user-bio-section-body"},[s("div",{staticClass:"progress-item"},[s("span",[e._v("能力")]),e._v(" "),s("el-progress",{attrs:{percentage:90}})],1),e._v(" "),s("div",{staticClass:"progress-item"},[s("span",[e._v("能力")]),e._v(" "),s("el-progress",{attrs:{percentage:88}})],1),e._v(" "),s("div",{staticClass:"progress-item"},[s("span",[e._v("能力")]),e._v(" "),s("el-progress",{attrs:{percentage:95}})],1),e._v(" "),s("div",{staticClass:"progress-item"},[s("span",[e._v("能力")]),e._v(" "),s("el-progress",{attrs:{percentage:100,status:"success"}})],1)])])])])},a=[],n=s("3cbc"),i={components:{PanThumb:n["a"]},props:{user:{type:Object,default:function(){return{name:null,email:null,avatar:null,roles:null}}}}},c=i,o=(s("b5cc"),s("2877")),l=Object(o["a"])(c,r,a,!1,null,"1800dfaa",null);t["default"]=l.exports},9195:function(e,t,s){},b5cc:function(e,t,s){"use strict";var r=s("9195"),a=s.n(r);a.a},ecac:function(e,t,s){"use strict";s.r(t);var r=function(){var e=this,t=e.$createElement,s=e._self._c||t;return s("div",{staticClass:"app-container"},[e.user?s("div",[s("el-row",{attrs:{gutter:20}},[s("el-col",{attrs:{span:24,xs:24}},[s("user-card",{attrs:{user:e.user}})],1)],1)],1):e._e()])},a=[],n=(s("8e6e"),s("ac6a"),s("456d"),s("7f7f"),s("bd86")),i=s("2f62"),c=s("7faf"),o=s("53c3"),l=s.n(o);function u(e,t){var s=Object.keys(e);if(Object.getOwnPropertySymbols){var r=Object.getOwnPropertySymbols(e);t&&(r=r.filter(function(t){return Object.getOwnPropertyDescriptor(e,t).enumerable})),s.push.apply(s,r)}return s}function v(e){for(var t=1;t<arguments.length;t++){var s=null!=arguments[t]?arguments[t]:{};t%2?u(s,!0).forEach(function(t){Object(n["a"])(e,t,s[t])}):Object.getOwnPropertyDescriptors?Object.defineProperties(e,Object.getOwnPropertyDescriptors(s)):u(s).forEach(function(t){Object.defineProperty(e,t,Object.getOwnPropertyDescriptor(s,t))})}return e}var p={name:"Profile",components:{UserCard:c["default"]},data:function(){return{user:{},activeTab:"activity"}},computed:v({},Object(i["b"])(["name","avatar","roles","userInfo"])),created:function(){this.getUser()},methods:{getUser:function(){this.user={name:this.name,role:this.userInfo.orgName,email:"admin@test.com",avatar:this.avatar?this.avatar:l.a}}}},d=p,f=s("2877"),b=Object(f["a"])(d,r,a,!1,null,null,null);t["default"]=b.exports}}]);