package ifc;

public enum IKey {
	// Necessary
	// �����Դ����
	KEY_SOURCE,
	// ��Դ��ַ
	KEY_ADDRESS,
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
	// ת����
	KEY_RETWEETS,
	// �Ķ���
	KEY_PERUSED,
	// ����
	KEY_FAVORITES,
	// ����
	KEY_DISLIKES,
	// ������
	KEY_COMMENTATOR,
	// ��������
	KEY_COMMENT,
	// ����ʱ��
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
