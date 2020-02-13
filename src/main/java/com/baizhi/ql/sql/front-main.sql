

select count(*) from 
		(select b.id,book_name,author,price,dd_price,company,publish_time,
		       public_count,isbn,print_time,print_count,sale_count,
		       cate_id,e_recommend,src,stock,edition,impression,format,paper,packaging,pagination,recom,
		       brief,about_author,directory,media,
		       c.id,c.cate_name,c.parent_id,c.levels
			from d_book b
			join d_category c
			on b.cate_id=c.id
			where c.parent_id='1')
--点击分类浏览
select c.id cid,c.cate_name cname,c.count ccount,c.parent_id cparentId,c.levels clevels,
	   s.id sid,s.cate_name sname,s.count scount,s.parent_id sparentId,s.levels slevels 
from d_category c join d_category s on c.id=s.parent_id
where c.id='1'


--查一个
select b.*,c1.cate_name,c2.cate_name 
from d_book b
join d_category c1
on b.cate_id = c1.id
join d_category c2
on c1.parent_id = c2.id
where b.id='101'

--4.最新上架
select id,bookName,author,price,ddPrice,company,publishTime,
		       publicCount,isbn,printTime,printCount,saleCount,
		       cateId,eRecommend,src,stock,edition,impression,format,paper,packaging,pagination,recom,
		       brief,aboutAuthor,directory,media,
		       rownum from
(select id,book_name bookName,author,price,dd_price ddPrice,company,publish_time publishTime,
		       public_count publicCount,isbn,print_time printTime,print_count printCount,sale_count saleCount,
		       cate_id cateId,e_recommend eRecommend,src,stock,edition,impression,format,paper,packaging,pagination,recom,
		       brief,about_author aboutAuthor,directory,media
		from d_book
		order by publish_time desc)tb1 where rownum<=8
--5.新书热卖
select id,bookName,author,price,ddPrice,company,publishTime,
		       publicCount,isbn,printTime,printCount,saleCount,
		       cateId,eRecommend,src,stock,edition,impression,format,paper,packaging,pagination,recom,
		       brief,aboutAuthor,directory,media,
		       rownum from
(select id,book_name bookName,author,price,dd_price ddPrice,company,publish_time publishTime,
		       public_count publicCount,isbn,print_time printTime,print_count printCount,sale_count saleCount,
		       cate_id cateId,e_recommend eRecommend,src,stock,edition,impression,format,paper,packaging,pagination,recom,
		       brief,about_author aboutAuthor,directory,media
		from d_book
		order by sale_count desc,publish_time desc)tb1 where rownum<=8
--3.热销图书
select id,bookName,author,price,ddPrice,company,publishTime,
		       publicCount,isbn,printTime,printCount,saleCount,
		       cateId,eRecommend,src,stock,edition,impression,format,paper,packaging,pagination,recom,
		       brief,aboutAuthor,directory,media,
		       rownum from
(select id,book_name bookName,author,price,dd_price ddPrice,company,publish_time publishTime,
		       public_count publicCount,isbn,print_time printTime,print_count printCount,sale_count saleCount,
		       cate_id cateId,e_recommend eRecommend,src,stock,edition,impression,format,paper,packaging,pagination,recom,
		       brief,about_author aboutAuthor,directory,media
		from d_book where sale_count>0
		order by sale_count desc)tb1 where rownum<=8
--2.编辑推荐

select id,bookName,author,price,ddPrice,company,publishTime,
		       publicCount,isbn,printTime,printCount,saleCount,
		       cateId,eRecommend,src,stock,edition,impression,format,paper,packaging,pagination,recom,
		       brief,aboutAuthor,directory,media,
		       rownum from
		(select id,book_name bookName,author,price,dd_price ddPrice,company,publish_time publishTime,
		       public_count publicCount,isbn,print_time printTime,print_count printCount,sale_count saleCount,
		       cate_id cateId,e_recommend eRecommend,src,stock,edition,impression,format,paper,packaging,pagination,recom,
		       brief,about_author aboutAuthor,directory,media
		from d_book order by dbms_random.random())tb1 
		where rownum <=2		
		
--1.查询类别
select d1.id Id1,d1.cate_name cateName1,d1.count count1,d1.parent_id parentId1,d1.levels levels1,
		d2.id Id2,d2.cate_name cateName2,d2.count count2,d2.parent_id parentId2,d2.levels levels2
		from d_category d1
		left join d_category d2
		on d1.id=d2.parent_id
		where d1.levels=1