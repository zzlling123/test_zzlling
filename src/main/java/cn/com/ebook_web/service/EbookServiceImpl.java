package cn.com.ebook_web.service;

import cn.com.ebook_web.dao.EbookMapper;
import cn.com.ebook_web.pojo.Category;
import cn.com.ebook_web.pojo.Entry;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class EbookServiceImpl implements EbookService {
    @Resource
    private EbookMapper ebookMapper;
    @Override
    public List<Entry> getEbooks(String categoryId, int pageSize, int currentPage) {
        int limit1=(currentPage-1)*pageSize;
        int limit2=pageSize;
        return ebookMapper.getEbooks(categoryId, limit1, limit2);
    }

    @Override
    public int getEbookscount(String categoryId) {
        return ebookMapper.getEbookCount(categoryId);
    }

    @Override
    public List<Category> getCategorys() {
        return ebookMapper.getCategorys();
    }

    @Override
    public int add(Entry entry) {
        return ebookMapper.add(entry);
    }

    @Override
    public Entry getEntry(int id) {
        return ebookMapper.getEntry(id);
    }

    @Override
    public int update(Entry entry) {
        return ebookMapper.update(entry);
    }

    @Override
    public int delete(int id) {
        return ebookMapper.delete(id);
    }
}
