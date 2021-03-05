package com.revature.models;

public class ReimbursementStatus {

		private int id;
		private String status;
		
		public ReimbursementStatus() {
			
		}

		public ReimbursementStatus(int id, String status) {
			super();
			this.id = id;
			this.status = status;
		}

		/**
		 * @return the id
		 */
		public int getId() {
			return id;
		}

		/**
		 * @param id the id to set
		 */
		public void setId(int id) {
			this.id = id;
		}

		/**
		 * @return the status
		 */
		public String getStatus() {
			return status;
		}

		/**
		 * @param status the status to set
		 */
		public void setStatus(String status) {
			this.status = status;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + id;
			result = prime * result + ((status == null) ? 0 : status.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			ReimbursementStatus other = (ReimbursementStatus) obj;
			if (id != other.id)
				return false;
			if (status == null) {
				if (other.status != null)
					return false;
			} else if (!status.equals(other.status))
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "ReimbursementStatus [id=" + id + ", status=" + status + "]";
		}
		
		
		
}
