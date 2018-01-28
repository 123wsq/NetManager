package com.wsq.net.manager.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.ServletRequestUtils;

public class ServletUtil{
	
  String REQUESTED_AJAX = "XMLHttpRequest";
  String HEADER_REQUESTED = "X-Requested-With";

  public static Map<String, Object> getParamMap(HttpServletRequest req){
	  
    return getParamMap(req, null);
  }

  public static Map<String, Object> getParamMap(HttpServletRequest req, Map<String, Object> map){
    
	  if (map == null) {
      map = new HashMap<String, Object>();
    }

    Map <String, Object>paramMap = req.getParameterMap();
    if ((paramMap == null) || (paramMap.isEmpty())) {
      return map;
    }

    Set<String> keySet = paramMap.keySet();
    
    for (String key : keySet) {
      String[] values = (String[])paramMap.get(key);
      if ((values == null) || (values.length == 0))
        map.put(key, "");
      else if (values.length == 1)
        map.put(key, values[0]);
      else {
        map.put(key, values);
      }
    }
    return map;
  }

  public boolean isAjaxRequest(HttpServletRequest request){
	  
    String requestType = request.getHeader(this.HEADER_REQUESTED);

    if (this.REQUESTED_AJAX.equalsIgnoreCase(requestType)) {
      return true;
    }

    return false;
  }
}