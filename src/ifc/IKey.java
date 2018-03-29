package ifc;

public enum IKey {
	// Necessary
	// 必填：来源名称
	KEY_SOURCE,
	// 来源地址
	KEY_ADDRESS,
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
	// 转发数
	KEY_RETWEETS,
	// 阅读数
	KEY_PERUSED,
	// 赞数
	KEY_FAVORITES,
	// 踩数
	KEY_DISLIKES,
	// 评论人
	KEY_COMMENTATOR,
	// 评论内容
	KEY_COMMENT,
	// 评论时间
	KEY_COMMENTED;

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
			return "";
		case KEY_ADDRESS:
			return "";
		case KEY_TITLE:
			return "";
		case KEY_CONTENT:
			return "";
		case KEY_CREATED:
			return "";
		case KEY_GATHERING:
			return "";
		case KEY_AUTHOR:
			return "";
		case KEY_SUMMARY:
			return "";
		case KEY_CATEGORY:
			return "";
		case KEY_COLUMN:
			return "";
		case KEY_THUMB:
			return "";
		case KEY_TAG:
			return "";
		case KEY_RETWEETS:
			return "";
		case KEY_PERUSED:
			return "";
		case KEY_FAVORITES:
			return "";
		case KEY_DISLIKES:
			return "";
		case KEY_COMMENTATOR:
			return "";
		case KEY_COMMENT:
			return "";
		case KEY_COMMENTED:
			return "";
		}
		return null;
	}
}
