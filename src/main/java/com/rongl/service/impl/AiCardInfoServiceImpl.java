package com.rongl.service.impl;

import com.rongl.common.BCardUtils;
import com.rongl.entity.AiCardInfo;
import com.rongl.mapper.AiCardInfoMapper;
import com.rongl.service.IAiCardInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.unfbx.chatgpt.OpenAiClient;
import com.unfbx.chatgpt.entity.chat.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 李中华
 * @since 2024-10-24
 */
@Service
@Slf4j
public class AiCardInfoServiceImpl extends ServiceImpl<AiCardInfoMapper, AiCardInfo> implements IAiCardInfoService {

    @Override
    public List<AiCardInfo> listAll() {
        log.info("开始  listAll");
        return null;
    }

    @Override
    public String  uploadFile(String filePath) {
        String path = "";
        log.info("外部访问路径：： "+filePath);

        OpenAiClient client = BCardUtils.initOpenAI();
        Content textContent = Content.builder().text("请帮识别图片的格式 ，文字内容，谢谢").type(Content.Type.TEXT.getName()).build();//What’s in this image?
        ImageUrl imageUrl = ImageUrl.builder().url(filePath).build();
//        ImageUrl imageUrl = ImageUrl.builder().url("D:\\bCard\\png\\Gfp-wisconsin-madison-the-nature-boardwalk.jpg.webp").build();
        Content imageContent = Content.builder().imageUrl(imageUrl).type(Content.Type.IMAGE_URL.getName()).build();

        List<Content> contentList = new ArrayList<>();
        contentList.add(textContent);
        contentList.add(imageContent);
        MessagePicture message = MessagePicture.builder().role(Message.Role.USER).content(contentList).build();
        ChatCompletionWithPicture chatCompletion = ChatCompletionWithPicture
                .builder()
                .messages(Collections.singletonList(message))
                .model(ChatCompletion.Model.GPT_4o_VISION_MIMI.getName())
                .build();
        ChatCompletionResponse chatCompletionResponse = client.chatCompletion(chatCompletion);
        StringBuffer  sb = new StringBuffer();
        chatCompletionResponse.getChoices().forEach(e -> {

            log.info("openai return :  -->"+e.getMessage().getContent());
            sb.append(e.getMessage().getContent());
        });
        return sb.toString();

    }
}
