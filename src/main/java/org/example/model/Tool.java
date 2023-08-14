package org.example.model;

public class Tool {
    private ToolCode toolCode;
    private ToolType toolType;
    private ToolBrand toolBrand;

    public Tool() {}

    public Tool(ToolCode toolCode, ToolType toolType, ToolBrand toolBrand) {
        this.toolCode = toolCode;
        this.toolType = toolType;
        this.toolBrand = toolBrand;
    }

    public ToolCode getToolCode() {
        return toolCode;
    }

    public void setToolCode(ToolCode toolCode) {
        this.toolCode = toolCode;
    }

    public ToolType getToolType() {
        return toolType;
    }

    public void setToolType(ToolType toolType) {
        this.toolType = toolType;
    }

    public ToolBrand getToolBrand() {
        return toolBrand;
    }

    public void setToolBrand(ToolBrand toolBrand) {
        this.toolBrand = toolBrand;
    }
}
