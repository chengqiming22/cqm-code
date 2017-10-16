<#import "layout/layout.ftl" as layout>
<@layout.layout>
<link href="${rc.contextPath}/css/index.css" rel="stylesheet">
<div class="row">
    <div class="col-md-9 col-sm-8 col-xs-12">
        <h1>博客列表</h1>
        <div id="editor">
            <textarea :value="input" @input="update"></textarea>
            <div v-html="compiledMarkdown"></div>
        </div>
    </div>
    <div class="col-md-3 col-sm-4 col-xs-12">
        <#include "layout/sidebar.ftl">
    </div>
</div>
<script src="${rc.contextPath}/js/index.js"></script>
</@layout.layout>