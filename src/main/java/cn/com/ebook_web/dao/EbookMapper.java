package cn.com.ebook_web.dao;

import cn.com.ebook_web.pojo.Category;
import cn.com.ebook_web.pojo.Entry;

import java.util.List;

public interface EbookMapper {
    public List<Entry> getEbooks(String categoryId, int limit1, int limit2);

    public int getEbookCount(String categoryId);

    public List<Category> getCategorys();

    public int add(Entry entry);

    public int update(Entry entry);

    public int delete(int id);

    public Entry getEntry(int id);
}
