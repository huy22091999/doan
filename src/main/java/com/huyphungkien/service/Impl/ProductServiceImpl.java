package com.huyphungkien.service.Impl;

import com.huyphungkien.entity.Category;
import com.huyphungkien.entity.Image;
import com.huyphungkien.entity.Product;
import com.huyphungkien.entity.TypePro;
import com.huyphungkien.model.ImageDto;
import com.huyphungkien.model.ProductDto;
import com.huyphungkien.model.TypeDto;
import com.huyphungkien.repository.*;
import com.huyphungkien.service.CartService;
import com.huyphungkien.service.ProductService;
import com.huyphungkien.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository pr;
    @Autowired
    private CategoryRepository cr;
    @Autowired
    private StorageService ss;
    @Autowired
    private ImageRepository ir;
    @Autowired
    private TypeRepository tr;
    @Override
    @Query("select new huyphungkien.model.ProductDto(p) from Product p")
    public Page<ProductDto> getPage(Pageable pageable) {
        return null;
    }

    @Override
    public Product getById(Long aLong) {
        return pr.getById(aLong);
    }

    @Override
    public ProductDto save(ProductDto dto) {
        if(dto==null)
            return null;
        Product product=null;
        if(dto.getId()!=null)
            product=pr.getOne(dto.getId());
        if(product==null){
            product=new Product();
        }
        product.setName(dto.getName());
        product.setQuantity(dto.getQuantity());
        product.setDescription(dto.getDescription());
        if(dto.getCategory()!=null&&dto.getCategory().getId()!=null){
            product.setCategory(cr.getOne(dto.getCategory().getId()));
        }
        product=pr.save(product);
        if(dto.getFiles()!=null&&dto.getFiles().size()>0){
            for (MultipartFile m:dto.getFiles()) {
                if(m!=null){
                    UUID uuid=UUID.randomUUID();
                    Image i=new Image();
                    i.setImg(ss.getStorageFileName(m,uuid.toString()));
                    i.setProduct(product);
                    ss.store(m,i.getImg());
                    ir.save(i);
                }
            }
        }
        if(dto.getTypes()!=null&&dto.getTypes().size()>0){
            for (TypeDto t:dto.getTypes()) {
                if(t!=null&&!t.getName().isEmpty()){
                    TypePro tp=new TypePro();
                    tp.setId(t.getId());
                    tp.setName(t.getName());
                    tp.setPrice(t.getPrice());
                    tp.setQuantity(t.getQuantity());
                    tp.setProduct(product);
                    tr.save(tp);
                }
            }
        }
        if(product!=null)
            return new ProductDto(product);
        return null;
    }

    @Override
    public void deleteById(Long aLong) {
        pr.deleteById(aLong);
    }
}
