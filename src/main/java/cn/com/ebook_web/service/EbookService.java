package cn.com.ebook_web.service;

import cn.com.ebook_web.pojo.Category;
import cn.com.ebook_web.pojo.Entry;

import java.util.List;

public interface EbookService {
    public List<Entry> getEbooks(String categoryId, int pageSize, int currentPage);

    public int getEbookscount(String categoryId);

    public List<Category> getCategorys();

    public int add(Entry entry);

    public Entry getEntry(int id);

    public int update(Entry entry);

    public int delete(int id);
}
