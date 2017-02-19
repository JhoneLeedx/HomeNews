package com.jhonlee.homenews.pojo;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by JhoneLee on 2017/2/17.
 */

public class Token implements Parcelable{


    /**
     * reason : 成功的返回
     * result : {"stat":"1","data":[{"uniquekey":"3bdf5efd011a2338fe91b4b4c7ab35ca","title":"咘咘掌握了新技能 玩单杠姿势666","date":"2017-02-17 14:04","category":"头条","author_name":"腾讯娱乐","url":"http://mini.eastday.com/mobile/170217140446615.html","thumbnail_pic_s":"http://09.imgmini.eastday.com/mobile/20170217/20170217140446_6193b256f9b22e57c6da62d2f07a829f_1_mwpm_03200403.jpeg","thumbnail_pic_s02":"http://09.imgmini.eastday.com/mobile/20170217/20170217140446_6193b256f9b22e57c6da62d2f07a829f_2_mwpm_03200403.jpeg","thumbnail_pic_s03":"http://09.imgmini.eastday.com/mobile/20170217/20170217140446_6193b256f9b22e57c6da62d2f07a829f_3_mwpm_03200403.jpeg"},{"uniquekey":"adcfb8510c1c69374b0c4013548e0785","title":"天津问责调料造假事件：12名官员被党纪政纪处分","date":"2017-02-17 13:58","category":"头条","author_name":"中国新闻网","url":"http://mini.eastday.com/mobile/170217135845121.html","thumbnail_pic_s":"http://01.imgmini.eastday.com/mobile/20170217/20170217135845_12c9b2575f28e00dbce266593931a0e9_1_mwpm_03200403.jpeg"},{"uniquekey":"8feb0b59bc8ad1fe5260a54af563a8b1","title":"世界第八洲？科学家：面积500万平方公里 九成在水下","date":"2017-02-17 13:40","category":"头条","author_name":"环球网","url":"http://mini.eastday.com/mobile/170217134005630.html","thumbnail_pic_s":"http://08.imgmini.eastday.com/mobile/20170217/20170217134005_a07a5abf28dd0a8547b4831bbe74b612_1_mwpm_03200403.jpeg"},{"uniquekey":"52b40b7ca2d8de85ecfd6aab3506675b","title":"优步印尼竞争对手Go-Jek将融资5-10亿美元","date":"2017-02-17 13:34","category":"头条","author_name":"环球网","url":"http://mini.eastday.com/mobile/170217133451458.html","thumbnail_pic_s":"http://09.imgmini.eastday.com/mobile/20170217/20170217133451_e03451c7d597b0ac528814d59b780f4b_1_mwpm_03200403.png"},{"uniquekey":"85949030e95eee21f9a2421d1936877d","title":"中央补助投资最高限额：普通高中3000万 本科高校1亿","date":"2017-02-17 13:34","category":"头条","author_name":"中国新闻网","url":"http://mini.eastday.com/mobile/170217133449438.html","thumbnail_pic_s":"http://04.imgmini.eastday.com/mobile/20170217/20170217133449_b0d2a61e0dc6b28b1fc8e59cb4faf83d_1_mwpm_03200403.jpeg"},{"uniquekey":"a90f15ee5e5eb285735a8084362778dc","title":"官方：普及高中教育 促高中教育毛入学率达90%","date":"2017-02-17 13:34","category":"头条","author_name":"中国新闻网","url":"http://mini.eastday.com/mobile/170217133447257.html","thumbnail_pic_s":"http://01.imgmini.eastday.com/mobile/20170217/20170217133447_16e9a10fb181e97e95de4d05f10b30c6_1_mwpm_03200403.jpeg"},{"uniquekey":"d1c2e2b003922884c1919d21abe868c9","title":"明星拍过的奇葩广告 画风突变让人猝不及防","date":"2017-02-17 13:34","category":"头条","author_name":"腾讯娱乐","url":"http://mini.eastday.com/mobile/170217133444559.html","thumbnail_pic_s":"http://03.imgmini.eastday.com/mobile/20170217/20170217133444_711216f6beb7caa1a3e81bbc8907a86c_1_mwpm_03200403.jpeg","thumbnail_pic_s02":"http://03.imgmini.eastday.com/mobile/20170217/20170217133444_711216f6beb7caa1a3e81bbc8907a86c_2_mwpm_03200403.jpeg","thumbnail_pic_s03":"http://03.imgmini.eastday.com/mobile/20170217/20170217133444_711216f6beb7caa1a3e81bbc8907a86c_3_mwpm_03200403.jpeg"},{"uniquekey":"defb6fdc6e8fa9d01122973517d21a19","title":"美国俄州一名囚犯威胁特朗普 邮寄白色粉末","date":"2017-02-17 13:25","category":"头条","author_name":"中国日报网","url":"http://mini.eastday.com/mobile/170217132534606.html","thumbnail_pic_s":"http://06.imgmini.eastday.com/mobile/20170217/20170217132534_8dffe70369aa0abb68684837643f2feb_1_mwpm_03200403.jpeg"},{"uniquekey":"d645e3651b422a5780c091a045a2810c","title":"浙江证监局今上午赴万家文化公司现场问询","date":"2017-02-17 13:10","category":"头条","author_name":"每日经济新闻","url":"http://mini.eastday.com/mobile/170217131045130.html","thumbnail_pic_s":"http://00.imgmini.eastday.com/mobile/20170217/20170217131045_a23ab74a315f83783c19dbe3c47728a4_1_mwpm_03200403.jpeg","thumbnail_pic_s02":"http://00.imgmini.eastday.com/mobile/20170217/20170217131045_a23ab74a315f83783c19dbe3c47728a4_2_mwpm_03200403.jpeg"},{"uniquekey":"8dc5aea5a9356e0c3805f22d67a75b9b","title":"远离健身的五大误区 让健身更有效","date":"2017-02-17 12:56","category":"头条","author_name":"99健康网","url":"http://mini.eastday.com/mobile/170217125612291.html","thumbnail_pic_s":"http://08.imgmini.eastday.com/mobile/20170217/20170217125612_028a847e4d256c15453998b413ed8466_1_mwpm_03200403.jpeg","thumbnail_pic_s02":"http://08.imgmini.eastday.com/mobile/20170217/20170217125612_028a847e4d256c15453998b413ed8466_2_mwpm_03200403.jpeg"},{"uniquekey":"4e300ab3db42a4a90344cfb26676e6d5","title":"日本红灯区实录：一个任你自由「恋爱」的男人天堂","date":"2017-02-17 12:45","category":"头条","author_name":"杜绍斐","url":"http://mini.eastday.com/mobile/170217124508481.html","thumbnail_pic_s":"http://09.imgmini.eastday.com/mobile/20170217/20170217124508_45b50eb77e2b51eccc5653917cdfc12d_1_mwpm_03200403.jpeg","thumbnail_pic_s02":"http://09.imgmini.eastday.com/mobile/20170217/20170217124508_45b50eb77e2b51eccc5653917cdfc12d_2_mwpm_03200403.jpeg","thumbnail_pic_s03":"http://09.imgmini.eastday.com/mobile/20170217/20170217124508_45b50eb77e2b51eccc5653917cdfc12d_3_mwpm_03200403.jpeg"},{"uniquekey":"fad037fd23f61b531ab7276ce4157c08","title":"三个小方法，锻炼\u201c熊孩子\u201d的注意力","date":"2017-02-17 12:41","category":"头条","author_name":"羊城晚报","url":"http://mini.eastday.com/mobile/170217124140769.html","thumbnail_pic_s":"http://00.imgmini.eastday.com/mobile/20170217/20170217124140_e336635227c70b34a39cd99ad782b6d6_1_mwpm_03200403.jpeg"},{"uniquekey":"4b4d38863e9cdef37631f7e22c73be4f","title":"马丽古天乐首演夫妻 喜剧女王又一力作引期待","date":"2017-02-17 12:40","category":"头条","author_name":"腾讯娱乐","url":"http://mini.eastday.com/mobile/170217124046748.html","thumbnail_pic_s":"http://04.imgmini.eastday.com/mobile/20170217/20170217124046_57612ee96c9e59c5318fb3507e380f72_1_mwpm_03200403.jpeg","thumbnail_pic_s02":"http://04.imgmini.eastday.com/mobile/20170217/20170217124046_57612ee96c9e59c5318fb3507e380f72_2_mwpm_03200403.jpeg"},{"uniquekey":"0e83e58c791b2190bdedf46a78793eec","title":"新华社副社长兼常务副总编周树春出任《中国日报》总编辑","date":"2017-02-17 12:34","category":"头条","author_name":"澎湃新闻","url":"http://mini.eastday.com/mobile/170217123432497.html","thumbnail_pic_s":"http://08.imgmini.eastday.com/mobile/20170217/20170217123432_a0b4cbbd0841bbfdd0a53042a1e7aaad_1_mwpm_03200403.jpeg"},{"uniquekey":"64825927c678d0d8f120a621b8462162","title":"文章真的爱赌博吗？从赌场到农村老家故意输钱！","date":"2017-02-17 12:30","category":"头条","author_name":"娱乐态度分析","url":"http://mini.eastday.com/mobile/170217123009670.html","thumbnail_pic_s":"http://08.imgmini.eastday.com/mobile/20170217/20170217123009_ec22c6e5eef758705b927401a13d5845_1_mwpm_03200403.jpeg","thumbnail_pic_s02":"http://08.imgmini.eastday.com/mobile/20170217/20170217123009_ec22c6e5eef758705b927401a13d5845_2_mwpm_03200403.jpeg","thumbnail_pic_s03":"http://08.imgmini.eastday.com/mobile/20170217/20170217123009_ec22c6e5eef758705b927401a13d5845_3_mwpm_03200403.jpeg"},{"uniquekey":"c67cba98e924b6ce46c886c4a6bd34b4","title":"美新任国务卿首会俄外长未谈制裁，欲就\u201c共同利益\u201d寻求合作","date":"2017-02-17 12:24","category":"头条","author_name":"澎湃新闻","url":"http://mini.eastday.com/mobile/170217122430988.html","thumbnail_pic_s":"http://02.imgmini.eastday.com/mobile/20170217/20170217122430_97dd2ea60b1aee3290232f9314a63a11_1_mwpm_03200403.jpeg"},{"uniquekey":"1ebd56107fe9e0e802eb329f9d09d1ad","title":"情人节当心被这些生肖男的套路迷惑双眼","date":"2017-02-17 12:23","category":"头条","author_name":"星座小分析师","url":"http://mini.eastday.com/mobile/170217122339757.html","thumbnail_pic_s":"http://05.imgmini.eastday.com/mobile/20170217/20170217122339_276bcc1ab982198efee5ed34da9cc8f0_1_mwpm_03200403.jpeg","thumbnail_pic_s02":"http://05.imgmini.eastday.com/mobile/20170217/20170217122339_276bcc1ab982198efee5ed34da9cc8f0_2_mwpm_03200403.jpeg","thumbnail_pic_s03":"http://05.imgmini.eastday.com/mobile/20170217/20170217122339_276bcc1ab982198efee5ed34da9cc8f0_3_mwpm_03200403.jpeg"},{"uniquekey":"20780ad348aa57f0983b8232dbe83ef2","title":"当综艺遇上电竞 《时间指挥官》带你玩转历史","date":"2017-02-17 12:22","category":"头条","author_name":"腾讯娱乐","url":"http://mini.eastday.com/mobile/170217122255372.html","thumbnail_pic_s":"http://01.imgmini.eastday.com/mobile/20170217/20170217122255_b54c167aa05dde1973c735ce6b60b723_1_mwpm_03200403.jpeg","thumbnail_pic_s02":"http://01.imgmini.eastday.com/mobile/20170217/20170217122255_b54c167aa05dde1973c735ce6b60b723_2_mwpm_03200403.jpeg","thumbnail_pic_s03":"http://01.imgmini.eastday.com/mobile/20170217/20170217122255_b54c167aa05dde1973c735ce6b60b723_3_mwpm_03200403.jpeg"},{"uniquekey":"61a392f2a3de2c4f8f52bf39e7fef1b7","title":"vivo X9Plus星空灰开卖 3298元买它送小哥哥？","date":"2017-02-17 12:22","category":"头条","author_name":"腾讯数码","url":"http://mini.eastday.com/mobile/170217122255323.html","thumbnail_pic_s":"http://05.imgmini.eastday.com/mobile/20170217/20170217122255_fa379d2a1d46376f20a8ee217df0a24f_1_mwpm_03200403.jpeg"},{"uniquekey":"d4c3e26e95d7a277f406007e1289b422","title":"伊朗海军击沉美军航母！伊朗一招吓坏美军！到底怎么回事？","date":"2017-02-17 12:12","category":"头条","author_name":"光阴没有姓名","url":"http://mini.eastday.com/mobile/170217121226087.html","thumbnail_pic_s":"http://09.imgmini.eastday.com/mobile/20170217/20170217121226_4fa538d37ead04661a8a9a940dff8299_1_mwpm_03200403.jpeg","thumbnail_pic_s02":"http://09.imgmini.eastday.com/mobile/20170217/20170217121226_4fa538d37ead04661a8a9a940dff8299_2_mwpm_03200403.jpeg"},{"uniquekey":"624969c818e14fc9add18823bda11984","title":"总把中国当对手 印度上将：中国崛起使我们面临挑战","date":"2017-02-17 12:09","category":"头条","author_name":"东方头条","url":"http://mini.eastday.com/mobile/170217120911534.html","thumbnail_pic_s":"http://00.imgmini.eastday.com/mobile/20170217/20170217120911_7bf1da9a7e052ef2552f1f70dbb10dea_1_mwpm_03200403.jpg"},{"uniquekey":"2d9ac87d6d2cc42c3f824117489b22b5","title":"拥有让人艳羡身材的女星，S曲线大长腿是必备","date":"2017-02-17 12:04","category":"头条","author_name":"腾讯娱乐","url":"http://mini.eastday.com/mobile/170217120438459.html","thumbnail_pic_s":"http://02.imgmini.eastday.com/mobile/20170217/20170217120438_3e5d9895c6f9ddd3c40f44dceb598822_1_mwpm_03200403.jpeg","thumbnail_pic_s02":"http://02.imgmini.eastday.com/mobile/20170217/20170217120438_3e5d9895c6f9ddd3c40f44dceb598822_2_mwpm_03200403.jpeg","thumbnail_pic_s03":"http://02.imgmini.eastday.com/mobile/20170217/20170217120438_3e5d9895c6f9ddd3c40f44dceb598822_3_mwpm_03200403.jpeg"},{"uniquekey":"c87775bacbba51a76bdd7d9b6ce06176","title":"世界最大\u201c牛魔王\u201d，印度这牛不是吹的，重达一吨半，老虎都害怕","date":"2017-02-17 12:02","category":"头条","author_name":"宇宙万能镜","url":"http://mini.eastday.com/mobile/170217120231931.html","thumbnail_pic_s":"http://07.imgmini.eastday.com/mobile/20170217/20170217120231_a9a2311c792caf150472fc3c85f97bbb_1_mwpm_03200403.jpeg","thumbnail_pic_s02":"http://07.imgmini.eastday.com/mobile/20170217/20170217120231_a9a2311c792caf150472fc3c85f97bbb_2_mwpm_03200403.jpeg","thumbnail_pic_s03":"http://07.imgmini.eastday.com/mobile/20170217/20170217120231_a9a2311c792caf150472fc3c85f97bbb_3_mwpm_03200403.jpeg"},{"uniquekey":"153e05ee7d84f97a27623942668f5835","title":"刘晓庆的腿 女人看了会流泪","date":"2017-02-17 11:58","category":"头条","author_name":"腾讯娱乐","url":"http://mini.eastday.com/mobile/170217115846389.html","thumbnail_pic_s":"http://03.imgmini.eastday.com/mobile/20170217/20170217115846_9908fe2856c59c72f715d67e7e56862f_1_mwpm_03200403.jpeg","thumbnail_pic_s02":"http://03.imgmini.eastday.com/mobile/20170217/20170217115846_9908fe2856c59c72f715d67e7e56862f_2_mwpm_03200403.jpeg","thumbnail_pic_s03":"http://03.imgmini.eastday.com/mobile/20170217/20170217115846_9908fe2856c59c72f715d67e7e56862f_3_mwpm_03200403.jpeg"},{"uniquekey":"b647ada9298bc20060dbe763baf01e00","title":"男子打开家门床上惊现陌生男 藏300个鸡蛋4天全被吃光","date":"2017-02-17 11:57","category":"头条","author_name":"东方头条","url":"http://mini.eastday.com/mobile/170217115746119.html","thumbnail_pic_s":"http://07.imgmini.eastday.com/mobile/20170217/20170217115746_cef62f0017edc6384ab7a66d4f0b0514_1_mwpm_03200403.jpg"},{"uniquekey":"ccc016f7b3340da939339b334554c011","title":"广州妈妈怀孕 7 次都流产 这次宝宝仅 1 斤","date":"2017-02-17 11:56","category":"头条","author_name":"腾讯大粤网","url":"http://mini.eastday.com/mobile/170217115626629.html","thumbnail_pic_s":"http://04.imgmini.eastday.com/mobile/20170217/20170217115626_9cb5dfc24aaa7adcd235cd7fe3d36a28_1_mwpm_03200403.jpeg","thumbnail_pic_s02":"http://04.imgmini.eastday.com/mobile/20170217/20170217115626_9cb5dfc24aaa7adcd235cd7fe3d36a28_2_mwpm_03200403.jpeg","thumbnail_pic_s03":"http://04.imgmini.eastday.com/mobile/20170217/20170217115626_9cb5dfc24aaa7adcd235cd7fe3d36a28_3_mwpm_03200403.jpeg"},{"uniquekey":"2ee89434d9934a1acf365410154e6a6d","title":"中国核弹头不及美俄零头为何没人敢动？俄专家的大实话令人顿悟","date":"2017-02-17 11:53","category":"头条","author_name":"热血武器","url":"http://mini.eastday.com/mobile/170217115330757.html","thumbnail_pic_s":"http://02.imgmini.eastday.com/mobile/20170217/20170217115330_188baf4100c0f0fb50409253f1767847_1_mwpm_03200403.jpeg","thumbnail_pic_s02":"http://02.imgmini.eastday.com/mobile/20170217/20170217115330_188baf4100c0f0fb50409253f1767847_2_mwpm_03200403.jpeg","thumbnail_pic_s03":"http://02.imgmini.eastday.com/mobile/20170217/20170217115330_188baf4100c0f0fb50409253f1767847_3_mwpm_03200403.jpeg"},{"uniquekey":"d55a0f7878e70a8c450ab9513438674e","title":"早观世界 | 这可是真真是\u201c虎口拔牙\u201d\u2026\u2026","date":"2017-02-17 11:50","category":"头条","author_name":"央广新闻","url":"http://mini.eastday.com/mobile/170217115001618.html","thumbnail_pic_s":"http://06.imgmini.eastday.com/mobile/20170217/20170217115001_683bf61582a0afefbcdfc93d20b9d08a_2_mwpm_03200403.jpeg","thumbnail_pic_s02":"http://06.imgmini.eastday.com/mobile/20170217/20170217115001_683bf61582a0afefbcdfc93d20b9d08a_3_mwpm_03200403.jpeg","thumbnail_pic_s03":"http://06.imgmini.eastday.com/mobile/20170217/20170217115001_683bf61582a0afefbcdfc93d20b9d08a_4_mwpm_03200403.jpeg"},{"uniquekey":"d18fd3b84cba403549ef4d0c483078b0","title":"午评：大盘翻绿水下震荡沪指跌0.46% 高位次新股大幅杀跌","date":"2017-02-17 11:49","category":"头条","author_name":"新浪","url":"http://mini.eastday.com/mobile/170217114947710.html","thumbnail_pic_s":"http://02.imgmini.eastday.com/mobile/20170217/20170217114947_63fa5dc12cedc7305fc2d77e4b6d3e5d_1_mwpm_03200403.png"},{"uniquekey":"68a276ac16c0ac3873e51ccf2f5fb566","title":"64名成员遇空难，俄罗斯\u201c国宝级\u201d歌舞团新组团后举行首演","date":"2017-02-17 11:45","category":"头条","author_name":"澎湃新闻","url":"http://mini.eastday.com/mobile/170217114510432.html","thumbnail_pic_s":"http://07.imgmini.eastday.com/mobile/20170217/20170217114510_f7f0a4603e82fbacccaa55edd707b083_1_mwpm_03200403.jpeg","thumbnail_pic_s02":"http://07.imgmini.eastday.com/mobile/20170217/20170217114510_f7f0a4603e82fbacccaa55edd707b083_2_mwpm_03200403.jpeg"}]}
     * error_code : 0
     */

    private String reason;
    private ResultBean result;
    private int error_code;

    protected Token(Parcel in) {
        reason = in.readString();
        error_code = in.readInt();
    }

    public static final Creator<Token> CREATOR = new Creator<Token>() {
        @Override
        public Token createFromParcel(Parcel in) {
            return new Token(in);
        }

        @Override
        public Token[] newArray(int size) {
            return new Token[size];
        }
    };

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(reason);
        parcel.writeInt(error_code);
    }

    public static class ResultBean {


        private String stat;
        private List<News> data;
        public String getStat() {
            return stat;
        }

        public void setStat(String stat) {
            this.stat = stat;
        }

        public List<News> getData() {
            return data;
        }

        public void setData(List<News> data) {
            this.data = data;
        }
    }
}
