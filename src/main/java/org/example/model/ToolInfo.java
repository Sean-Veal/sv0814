package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ToolInfo {
    private ToolCode toolCode;
    private ToolType toolType;
    private ToolBrand toolBrand;

    public static Map<ToolCode, ToolInfo> toolInfoMap() {
        Map<ToolCode, ToolInfo> toolMap = new HashMap<>();
        toolMap.put(ToolCode.CHNS, new ToolInfo(ToolCode.CHNS, ToolType.CHAINSAW, ToolBrand.STIHL));
        toolMap.put(ToolCode.LADW, new ToolInfo(ToolCode.LADW, ToolType.LADDER, ToolBrand.WERNER));
        toolMap.put(ToolCode.JAKD, new ToolInfo(ToolCode.JAKD, ToolType.JACKHAMMER, ToolBrand.DEWALT));
        toolMap.put(ToolCode.JAKR, new ToolInfo(ToolCode.JAKR, ToolType.JACKHAMMER, ToolBrand.RIDGID));
        return toolMap;
    }
}
