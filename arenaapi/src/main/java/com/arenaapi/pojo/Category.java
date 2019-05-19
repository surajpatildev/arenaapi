package com.arenaapi.pojo;

import java.util.Date;
import java.util.List;

public class Category {
	
	private boolean activated;
	private boolean allowDuplicateRevisions;
	private boolean allowManualRevisionEntry;
	private boolean assignable;
	private Date creationDateTime;
	private Creator creator;
	private String description;
	private String effectivityType;
	private boolean enforceDefaultEffectivityType;
	private boolean enforceDefaultNumberSequence;
	private String guid;
	private String initialImplementationStatus;
	private int level;
	private String name;
	//private NumberFormat numberFormat;
	//private NumberingSequencePrefixDefault numberingSequencePrefixDefault;
	private String path;
	private List<Object> requirements;
	private boolean systemDefined;
	public boolean isActivated() {
		return activated;
	}
	public void setActivated(boolean activated) {
		this.activated = activated;
	}
	public boolean isAllowDuplicateRevisions() {
		return allowDuplicateRevisions;
	}
	public void setAllowDuplicateRevisions(boolean allowDuplicateRevisions) {
		this.allowDuplicateRevisions = allowDuplicateRevisions;
	}
	public boolean isAllowManualRevisionEntry() {
		return allowManualRevisionEntry;
	}
	public void setAllowManualRevisionEntry(boolean allowManualRevisionEntry) {
		this.allowManualRevisionEntry = allowManualRevisionEntry;
	}
	public boolean isAssignable() {
		return assignable;
	}
	public void setAssignable(boolean assignable) {
		this.assignable = assignable;
	}
	public Date getCreationDateTime() {
		return creationDateTime;
	}
	public void setCreationDateTime(Date creationDateTime) {
		this.creationDateTime = creationDateTime;
	}
	public Creator getCreator() {
		return creator;
	}
	public void setCreator(Creator creator) {
		this.creator = creator;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getEffectivityType() {
		return effectivityType;
	}
	public void setEffectivityType(String effectivityType) {
		this.effectivityType = effectivityType;
	}
	public boolean isEnforceDefaultEffectivityType() {
		return enforceDefaultEffectivityType;
	}
	public void setEnforceDefaultEffectivityType(boolean enforceDefaultEffectivityType) {
		this.enforceDefaultEffectivityType = enforceDefaultEffectivityType;
	}
	public boolean isEnforceDefaultNumberSequence() {
		return enforceDefaultNumberSequence;
	}
	public void setEnforceDefaultNumberSequence(boolean enforceDefaultNumberSequence) {
		this.enforceDefaultNumberSequence = enforceDefaultNumberSequence;
	}
	public String getGuid() {
		return guid;
	}
	public void setGuid(String guid) {
		this.guid = guid;
	}
	public String getInitialImplementationStatus() {
		return initialImplementationStatus;
	}
	public void setInitialImplementationStatus(String initialImplementationStatus) {
		this.initialImplementationStatus = initialImplementationStatus;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public List<Object> getRequirements() {
		return requirements;
	}
	public void setRequirements(List<Object> requirements) {
		this.requirements = requirements;
	}
	public boolean isSystemDefined() {
		return systemDefined;
	}
	public void setSystemDefined(boolean systemDefined) {
		this.systemDefined = systemDefined;
	}
	@Override
	public String toString() {
		return "Category [activated=" + activated + ", allowDuplicateRevisions=" + allowDuplicateRevisions
				+ ", allowManualRevisionEntry=" + allowManualRevisionEntry + ", assignable=" + assignable
				+ ", creationDateTime=" + creationDateTime + ", creator=" + creator + ", description=" + description
				+ ", effectivityType=" + effectivityType + ", enforceDefaultEffectivityType="
				+ enforceDefaultEffectivityType + ", enforceDefaultNumberSequence=" + enforceDefaultNumberSequence
				+ ", guid=" + guid + ", initialImplementationStatus=" + initialImplementationStatus + ", level=" + level
				+ ", name=" + name + ", path=" + path + ", requirements=" + requirements + ", systemDefined="
				+ systemDefined + "]\n";
	}
	
	
}
