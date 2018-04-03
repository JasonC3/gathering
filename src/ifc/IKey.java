package ifc;

public enum IKey {
	// Necessary
	// �����Դ����
	KEY_SOURCE,
	// ��Դ��ַ
	KEY_LOCATOR,
	// ����
	KEY_TITLE,
	// ����
	KEY_CONTENT,
	// ����ʱ��
	KEY_CREATED,
	// �ɼ�ʱ��
	KEY_GATHERING,
	// Optional
	// ����
	KEY_AUTHOR,
	// ժҪ
	KEY_SUMMARY,
	// ��Ѷ����
	KEY_CATEGORY,
	// ��Ŀ����
	KEY_COLUMN,
	// ����ͼ��ַ
	KEY_THUMB,
	// ��ǩ
	KEY_TAG,
	// �ؼ���
	KEY_KEYWORD,
	// ���
	KEY_AVAILABLE,
	// ����
	KEY_ATTACHMENT,
	// ת����
	KEY_RETWEETS,
	// �Ķ���
	KEY_PERUSED,
	// ����
	KEY_FAVORITES,
	// ����
	KEY_DISLIKES,
	// �ȶ�
	KEY_HOT,
	// ������
	KEY_COMMENTS,
	// ������
	KEY_COMMENTATOR,
	// ��������
	KEY_COMMENT,
	// ����ʱ��
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
