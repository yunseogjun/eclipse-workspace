package com.example.spring.myapp.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring.myapp.dto.EMPDTO;
import com.example.spring.myapp.dto.MENUDTO;
import com.example.spring.myapp.service.TestTableServiceImpl;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import redis.clients.jedis.Jedis;

@RestController
@RequiredArgsConstructor
public class TestTableController {

	@Resource
	private TestTableServiceImpl testtableService;
	@Resource
	private EMPDTO empdto;
	private MENUDTO menudto;



	@GetMapping(value="list")
	@Tag(name = "getName", description = "직원명단 조회")
	public ApiResponse getName(@RequestParam(required = false)   String id) throws Exception{
		if (id == null) id = "";

		List<EMPDTO> AllList = testtableService.SelectAllList(id);
		System.out.println(AllList);

        try (Jedis jedis = new Jedis("127.0.0.1", 6379)) {
            // 데이터 저장
            jedis.set("mykey1", "안녕하세요 윤석준11111111111111111111111111111");

            // 데이터 조회
            String value = jedis.get("mykey1");
            System.out.println("Redis에서 가져온 값: " + value);
        } catch (Exception e) {
            e.printStackTrace();
        }

		return ApiResponse.builder().data(Map.of("result", AllList)).build();
	}

	@GetMapping(value="menu")
	@Tag(name = "getName", description = "직원명단 조회")
	public List<MENUDTO> getMenu() throws Exception{
//		ModelAndView mav = new ModelAndView();

		List<MENUDTO> AllList = testtableService.SelectMenuList();
		System.out.println(AllList);

		return AllList;
	}

	@PostMapping(value="insert")
	@Tag(name = "empSale", description = "직원저장")
	public ApiResponse save(@RequestBody List<EMPDTO> saveDatas) throws Exception {
			System.out.println("insert recv data="+ saveDatas);
	    	testtableService.Insert(saveDatas);
	        return ApiResponse.builder().build();
	}
}
