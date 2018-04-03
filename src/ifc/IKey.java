package ifc;

public enum IKey {
	// Necessary
	// 必填：来源名称
	KEY_SOURCE,
	// 来源地址
	KEY_LOCATOR,
	// 标题
	KEY_TITLE,
	// 正文
	KEY_CONTENT,
	// 发布时间
	KEY_CREATED,
	// 采集时间
	KEY_GATHERING,
	// Optional
	// 作者
	KEY_AUTHOR,
	// 摘要
	KEY_SUMMARY,
	// 资讯类型
	KEY_CATEGORY,
	// 栏目名称
	KEY_COLUMN,
	// 缩略图地址
	KEY_THUMB,
	// 标签
	KEY_TAG,
	// 关键字
	KEY_KEYWORD,
	// 审核
	KEY_AVAILABLE,
	// 附件
	KEY_ATTACHMENT,
	// 转发数
	KEY_RETWEETS,
	// 阅读数
	KEY_PERUSED,
	// 赞数
	KEY_FAVORITES,
	// 踩数
	KEY_DISLIKES,
	// 热度
	KEY_HOT,
	// 评论数
	KEY_COMMENTS,
	// 评论人
	KEY_COMMENTATOR,
	// 评论内容
	KEY_COMMENT,
	// 评论时间
	KEY_COMMENTED,
	// Key Type
	// String
	TYPE_STR,
	// Numeric
	TYPE_NUM,
	// Boolean
	TYPE_BOOL,
	// Array
	TYPE_ARR,
	// Object
	TYPE_OBJ;

	/**
	 * Defines the labels.
	 * 
	 * @author Jason Chen
	 * @version 0.10a
	 * @param IKey
	 * @return Label for XML
	 */
	public static String getLabel(IKey key) {
		switch (key) {
		case KEY_SOURCE:
			return "fromsource";
		case KEY_LOCATOR:
			return "url";
		case KEY_TITLE:
			return "title";
		case KEY_CONTENT:
			return "txtdetail";
		case KEY_CREATED:
			return "createtime";
		case KEY_GATHERING:
			return "spidetime";
		case KEY_AUTHOR:
			return "author";
		case KEY_SUMMARY:
			return "remark";
		case KEY_CATEGORY:
			return "classid";
		case KEY_COLUMN:
			return "type";
		case KEY_THUMB:
			return "imgurl";
		case KEY_TAG:
			return "tags";
		case KEY_RETWEETS:
			return "favnum";
		case KEY_PERUSED:
			return "point";
		case KEY_FAVORITES:
			return "goodnum";
		case KEY_DISLIKES:
			return "badnum";
		case KEY_HOT:
			return "hot";
		case KEY_COMMENTS:
			return "comnum";
		case KEY_COMMENTATOR:
			return "";
		case KEY_COMMENT:
			return "";
		case KEY_COMMENTED:
			return "";
		case KEY_KEYWORD:
			return "keywords";
		case KEY_AVAILABLE:
			return "isavailable";
		case KEY_ATTACHMENT:
			return "isfujian";
		default:
			return "";
		}
	}

	public static IKey getType(IKey key) {
		switch (key) {
		case KEY_AVAILABLE:
			return TYPE_BOOL;
		case KEY_RETWEETS:
		case KEY_PERUSED:
		case KEY_FAVORITES:
		case KEY_DISLIKES:
		case KEY_HOT:
		case KEY_COLUMN:
		case KEY_COMMENTS:
			return TYPE_NUM;
		default:
			return TYPE_STR;
		}
	}
}
