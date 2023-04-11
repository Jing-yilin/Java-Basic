package com.hspedu.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName Regexp_
 * @Description 体验正则表达式
 * @Author zephyr
 * @Date 2022/6/17 22:19
 * @Version 1.0
 */
public class Regexp_ {
    public static void main(String[] args) {
        //加入我们用爬虫获得了如下文本
//        String content = "训练框架进一步优化了速度，完善了显存优化机制，" +
//                "并支持在框架外部自定义C++/CUDA OP。分布式训练新增LocalSGD" +
//                "、GEO-SGD等策略，大规模同步训练、异步训练速度继续提升，并支" +
//                "持K8S + Volcano任务提交。服务器端预测库增加C API，并支持版" +
//                "本兼容检查。发布Paddle Lite，定位高性能、多平台、轻量化的端" +
//                "侧预测引擎，并可作为服务器端预测库的加速库。PaddleServing新" +
//                "增超大规模分布式预估服务能力。PaddleSlim强化了量化训练功能，" +
//                "增加了基于硬件的小模型搜索功能。发布全新Seq2Seq相关API和文本生" +
//                "成模型样例。语义表示库新增XLNet预训练模型；开源EMNLP2019阅读理" +
//                "解竞赛冠军模型D-NET，同时支持18个不同抽取式阅读理解数据集打榜。" +
//                "发布飞桨多任务学习库PALM （PAddLe Multi-task learning），更" +
//                "便捷支持多任务机器学习调研。发布训练部署端到端的图像分割库Paddle" +
//                "Seg。图像分类新增EfficientNet等43个预训练模型。PaddleDetecti" +
//                "on新增2019 Objects365 Full Track冠军模型、BlazeFace等人脸检" +
//                "测小模型，行人检测和车辆检测的预训练模型。PaddleVideo新增Activit" +
//                "yNet Challenge 2019夺冠模型，扩展包含video caption、video gr" +
//                "ounding等模型。发布PaddleSpeech，包含语音识别模型DeepSpeech和语" +
//                "音合成模型 DeepVoice3。PaddleHub新增超参优化Auto Fine-tune功能" +
//                "，并全面提升Fine-tune功能的灵活性和易用性，预训练模型数量大幅增加。" +
//                "飞桨图学习框架PGL正式版发布，飞桨深度强化学习框架PARL并行能力进一步提" +
//                "升，支持进化算法。Paddle2ONNX和X2Paddle全面升级，飞桨和其他框架" +
//                "的模型互转更加方便。发布飞桨联邦学习框架PaddleFL。";

        String content = "<meta name=\"description\" content=\"飞桨（PaddlePaddle）以百度多年的深度学习技术研究和业务应用为基础，集深度学习核心训练和推理框架、基础模型库、端到端开发套件、丰富的工具组件于一体，是中国首个自主研发、功能完备、开源开放的产业级深度学习平台。IDC发布的2021年上半年深度学习框架平台市场份额报告显示，百度跃居中国深度学习平台市场综合份额第一。百度飞桨汇聚开发者数量达370万，服务 14 万企事业单位，产生了42.5 万个模型。飞桨助力开发者快速实现AI想法，高效上线AI业务，帮助越来越多的行业完成AI赋能，实现产业智能化升级。\">\n" +
                "<title>飞桨（百度深度学习平台PaddlePaddle中文名）_百度百科</title>\n" +
                "<link rel=\"shortcut icon\" href=\"/favicon.ico\" type=\"image/x-icon\" />\n" +
                "<link rel=\"icon\" sizes=\"any\" mask href=\"//baikebcs.bdimg.com/cms/static/baike-icon.svg\">\n" +
                "\n" +
                "<meta name=\"csrf-token\" content=\"\">\n" +
                "<meta itemprop=\"dateUpdate\" content=\"2021-12-21 17:14:37\" />\n" +
                "<meta name=\"keywords\" content=\"飞桨, 飞桨发展历程, 飞桨领先技术, 飞桨建设成果, 飞桨硬件生态, 飞桨开发套件\">\n" +
                "<link rel=\"alternate\" hreflang=\"x-default\" href=\"https://baike.baidu.com/item/%E9%A3%9E%E6%A1%A8/23472642\" />\n" +
                "<link rel=\"alternate\" hreflang=\"zh\" href=\"https://baike.baidu.com/item/%E9%A3%9E%E6%A1%A8/23472642\" />\n" +
                "<link rel=\"alternate\" hreflang=\"zh-Hans\" href=\"https://baike.baidu.com/item/%E9%A3%9E%E6%A1%A8/23472642\" />\n" +
                "<link rel=\"alternate\" hreflang=\"zh-Hant\" href=\"https://baike.baidu.hk/item/%E9%A3%9B%E6%A7%B3/23472642\" />\n" +
                "<link rel=\"canonical\" href=\"https://baike.baidu.com/item/%E9%A3%9E%E6%A1%A8/23472642\" />\n" +
                "<meta name=\"image\" content=\"https://bkimg.cdn.bcebos.com/smart/f603918fa0ec08faa4c70b7b57ee3d6d54fbda23-bkimg-process,v_1,rw_1,rh_1,pad_1,color_ffffff?x-bce-process=image/format,f_auto\" />\n" +
                "<meta property=\"og:title\" content=\"飞桨_百度百科\" />\n" +
                "<meta property=\"og:description\" content=\"飞桨（PaddlePaddle）以百度多年的深度学习技术研究和业务应用为基础，集深度学习核心训练和推理框架、基础模型库、端到端开发套件、丰富的工具组件于一体，是中国首个自主研发、功能完备、开源开放的产业级深度学习平台。IDC发布的2021年上半年深度学习框架平台市场份额报告显示，百度跃居中国深度学习平台市场综合份额第一。百度飞桨汇聚开发者数量达370万，服务 14 万企事业单位，产生了42.5 万个模型。飞桨助力开发者快速实现AI想法，高效上线AI业务，帮助越来越多的行业完成AI赋能，实现产业智能化升级。\" />\n" +
                "<meta property=\"og:image\" content=\"https://bkimg.cdn.bcebos.com/smart/f603918fa0ec08faa4c70b7b57ee3d6d54fbda23-bkimg-process,v_1,rw_1,rh_1,pad_1,color_ffffff?x-bce-process=image/format,f_auto\" />\n" +
                "<meta property=\"og:url\" content=\"https://baike.baidu.com/item/%E9%A3%9E%E6%A1%A8/23472642\" />\n" +
                "<meta property=\"og:site_name\" content=\"百度百科\" />";
        //1. 先创建一个Pattern对象
//        Pattern pattern = Pattern.compile("[a-zA-Z]+");
        Pattern pattern = Pattern.compile("<title>(\\S*)</title>");
        //2. 创建一个匹配器对象
        Matcher matcher = pattern.matcher(content);
        //3.可以开始循环匹配
        while (matcher.find()){
            System.out.println("找到:\n " + matcher.group(1));
        }
    }
}
