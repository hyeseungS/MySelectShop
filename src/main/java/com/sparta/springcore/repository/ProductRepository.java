package com.sparta.springcore.repository;

import com.sparta.springcore.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Page<Product> findAllByUserId(Long userId, Pageable pageable);

    Page<Product> findAllByUserIdAndFolderList_Id(Long userId, Long folderId, Pageable pageable);
}

//import java.sql.*;
//import java.util.List;
//
//public class ProductRepository {
//
//    private final String dbUrl;
//    private final String dbId;
//    private final String dbPassword;
//
//    public ProductRepository(String dbUrl, String dbId, String dbPassword) {
//        this.dbUrl = dbUrl;
//        this.dbId = dbId;
//        this.dbPassword = dbPassword;
//    }
//
//    public void createProduct(Product product) throws SQLException {
//        // DB 연결
//        Connection connection = DriverManager.getConnection("jdbc:h2:mem:springcoredb", "sa", "");
//
//// DB Query 작성
//        PreparedStatement ps = connection.prepareStatement("select max(id) as id from product");
//        ResultSet rs = ps.executeQuery();
//        if (rs.next()) {
//// product id 설정 = product 테이블의 마지막 id + 1
//            product.setId(rs.getLong("id") + 1);
//        } else {
//            throw new SQLException("product 테이블의 마지막 id 값을 찾아오지 못했습니다.");
//        }
//        ps = connection.prepareStatement("insert into product(id, title, image, link, lprice, myprice) values(?, ?, ?, ?, ?, ?)");
//        ps.setLong(1, product.getId());
//        ps.setString(2, product.getTitle());
//        ps.setString(3, product.getImage());
//        ps.setString(4, product.getLink());
//        ps.setInt(5, product.getLprice());
//        ps.setInt(6, product.getMyprice());
//
//// DB Query 실행
//        ps.executeUpdate();
//
//// DB 연결 해제
//        ps.close();
//        connection.close();
//    }
//
//    public void updateProduct(Long id, ProductMypriceRequestDto requestDto, Product product) throws SQLException {
//        // DB 연결
//        Connection connection = DriverManager.getConnection("jdbc:h2:mem:springcoredb", "sa", "");
//
//// DB Query 작성
//        PreparedStatement ps = connection.prepareStatement("update product set myprice = ? where id = ?");
//        ps.setInt(1, requestDto.getMyprice());
//        ps.setLong(2, product.getId());
//
//// DB Query 실행
//        ps.executeUpdate();
//
//// DB 연결 해제
//        ps.close();
//        connection.close();
//    }
//
//    public void getProducts(List<Product> products) throws SQLException{
//        // DB 연결
//        Connection connection = DriverManager.getConnection("jdbc:h2:mem:springcoredb", "sa", "");
//
//// DB Query 작성 및 실행
//        Statement stmt = connection.createStatement();
//        ResultSet rs = stmt.executeQuery("select * from product");
//
//// DB Query 결과를 상품 객체 리스트로 변환
//        while (rs.next()) {
//            Product product = new Product();
//            product.setId(rs.getLong("id"));
//            product.setImage(rs.getString("image"));
//            product.setLink(rs.getString("link"));
//            product.setLprice(rs.getInt("lprice"));
//            product.setMyprice(rs.getInt("myprice"));
//            product.setTitle(rs.getString("title"));
//            products.add(product);
//        }
//
//// DB 연결 해제
//        rs.close();
//        connection.close();
//    }
//
//    public Product getProduct(Long id) throws SQLException{
//        Product product = new Product();
//        // DB 연결
//        Connection connection = DriverManager.getConnection("jdbc:h2:mem:springcoredb", "sa", "");
//
//// DB Query 작성
//        PreparedStatement ps = connection.prepareStatement("select * from product where id = ?");
//        ps.setLong(1, id);
//
//// DB Query 실행
//        ResultSet rs = ps.executeQuery();
//        if (rs.next()) {
//            product.setId(rs.getLong("id"));
//            product.setImage(rs.getString("image"));
//            product.setLink(rs.getString("link"));
//            product.setLprice(rs.getInt("lprice"));
//            product.setMyprice(rs.getInt("myprice"));
//            product.setTitle(rs.getString("title"));
//        } else {
//            throw new NullPointerException("해당 아이디가 존재하지 않습니다.");
//        }
//        // DB 연결 해제
//        rs.close();
//        ps.close();
//        connection.close();
//        return product;
//    }
//}
