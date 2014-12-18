package com.imoiseyenko.spastructure.common.util;

public enum Permissions {

	U(0x0000ffff);

	private int permissions;

	private Permissions(int permissions) {
		this.permissions = permissions;
	}

	public int getPermissions() {
		return permissions;
	}
}
