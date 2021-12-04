const axios = require("axios");

const fishingClassServices = {
  getAllFishingClass: () => {
    return axios.get(`${process.env.REACT_APP_API_URL}fishingClass`);
  },
  addFishingClass: (fishingClass) => {
    return axios.post(
      `${process.env.REACT_APP_API_URL}fishingClass`,
      fishingClass
    );
  },
  deleteFishingClass: (fishingClassID) => {
    return axios.delete(
      `${process.env.REACT_APP_API_URL}fishingClass/${fishingClassID}`
    );
  },
  updateFishingClass: (fishingClass) => {
    return axios.put(
      `${process.env.REACT_APP_API_URL}fishingClass/${fishingClass.id}`,
      cottage
    );
  },
  getFishingClassByInstructor: (instructorId) => {
    return axios.get(
      `${process.env.REACT_APP_API_URL}fishingClassInstructor?instructorId=${instructorId}`
    );
  },
  getFishingClassById: (fishingClassId) => {
    return axios.get(
      `${process.env.REACT_APP_API_URL}cottagesByOwner/${fishingClassId}`
    );
  },
  getShortBiographyByFishingClass: (fishingClassId) => {
    return axios.get(
      `${process.env.REACT_APP_API_URL}shortBiography?fishingClassId=${fishingClassId}`
    );
  },
  getFishingClassByInstructorAndName: (instructorId, fishingclassName) => {
    return axios.get(
      `${process.env.REACT_APP_API_URL}fishingClassName?instructorId=${instructorId}&fishingclassName=${fishingclassName}`
    );
  },

  ///////////////////////////// FishingClassReservations //////////////////////////////////////////////

  getAllFishingClassReservations: () => {
    return axios.get(
      `${process.env.REACT_APP_API_URL}fishingClassReservations`
    );
  },
  getUnavailableFishingClassReservationsByInstructor: (instructorId) => {
    return axios.get(
      `${process.env.REACT_APP_API_URL}fishingClassUnavailableReservation?instructorId=${instructorId}`
    );
  },
  getFinishedFishingClassReservationsByInstructor: (instructorId) => {
    return axios.get(
      `${process.env.REACT_APP_API_URL}fishingClassFinishedReservation?instructorId=${instructorId}`
    );
  },
  getFishingClassReservationById: (fishingClassReservationId) => {
    return axios.get(
      `${process.env.REACT_APP_API_URL}fishingClassFinishedReservation/${fishingClassReservationId}`
    );
  },
  createFishingClassReservation: () => {
    return axios.post(
      `${process.env.REACT_APP_API_URL}fishingClassReservations`
    );
  },
  updateFishingClassReservation: (fishingClassReservationId) => {
    return axios.put(
      `${process.env.REACT_APP_API_URL}fishingClassReservations/${fishingClassReservationId}`
    );
  },
  deleteFishingClassReservation: (fishingClassReservationId) => {
    return axios.delete(
      `${process.env.REACT_APP_API_URL}fishingClassReservations/${fishingClassReservationId}`
    );
  },
  getAllFishingClassReservationByClient: (clientId) => {
    return axios.get(
      `${process.env.REACT_APP_API_URL}fishingClassReservationsByClient/${clientId}`
    );
  },
  getAllFinishedFishingClassReservationByClient: (clientId) => {
    return axios.get(
      `${process.env.REACT_APP_API_URL}finishedFishingClassReservationsByClient/${clientId}`
    );
  },
  getAllFishingClassReservationAtPresentByClient: (clientId) => {
    return axios.get(
      `${process.env.REACT_APP_API_URL}fishingClassReservationsAtPresentByClient/${clientId}`
    );
  },
  getAllFinishedFishingClassReservationByClientSortedByDateAsc: (clientId) => {
    return axios.get(
      `${process.env.REACT_APP_API_URL}finishedFishingClassReservationsByClientSortedByDateAsc/${clientId}`
    );
  },
  getAllFinishedFishingClassReservationByClientSortedByDateDesc: (clientId) => {
    return axios.get(
      `${process.env.REACT_APP_API_URL}finishedFishingClassReservationsByClientSortedByDateDesc/${clientId}`
    );
  },
  getAllFinishedFishingClassReservationByClientSortedByDurationAsc: (
    clientId
  ) => {
    return axios.get(
      `${process.env.REACT_APP_API_URL}finishedFishingClassReservationsByClientSortedByDurationAsc/${clientId}`
    );
  },
  getAllFinishedFishingClassReservationByClientSortedByDurationDesc: (
    clientId
  ) => {
    return axios.get(
      `${process.env.REACT_APP_API_URL}finishedFishingClassReservationsByClientSortedByDurationDesc/${clientId}`
    );
  },

  ///////////////////////////// FishingClassQUICKReservations //////////////////////////////////////////////

  getAllFishingClassQuickReservations: () => {
    return axios.get(
      `${process.env.REACT_APP_API_URL}getAllFishingClassQuickReservations`
    );
  },
  getAllFreeFishingClassQuickReservation: (fishingClassId) => {
    return axios.get(
      `${process.env.REACT_APP_API_URL}getAllFreeFishingClassQuickReservation?fishingClassId=${fishingClassId}`
    );
  },
  getPriceWithDiscountQuickReservationByFishingClass: (fishingClassId) => {
    return axios.get(
      `${process.env.REACT_APP_API_URL}fishingClassDiscPrice?fishingClassId=${fishingClassId}`
    );
  },
  getPriceQuickReservationByFishingClass: (fishingClassId) => {
    return axios.get(
      `${process.env.REACT_APP_API_URL}fishingClassPrice?fishingClassId=${fishingClassId}`
    );
  },
  getUnavailableFishingClassQuickReservationsByInstructor: (instructorId) => {
    return axios.get(
      `${process.env.REACT_APP_API_URL}fishingClassUnavailableQuickReservation?instructorId=${instructorId}`
    );
  },
  getFinishedFishingClassQuickReservationsByInstructor: (instructorId) => {
    return axios.get(
      `${process.env.REACT_APP_API_URL}fishingClassFinishedQuickReservation?instructorId=${instructorId}`
    );
  },
  getFishingClassQuickReservationById: (fishingClassQuickReservationId) => {
    return axios.get(
      `${process.env.REACT_APP_API_URL}fishingClassQuickReservations/${fishingClassQuickReservationId}`
    );
  },
  createFishingClassQuickReservation: () => {
    return axios.post(
      `${process.env.REACT_APP_API_URL}fishingClassQuickReservations`
    );
  },
  updateFishingClassQuickReservation: (fishingClassQuickReservationId) => {
    return axios.put(
      `${process.env.REACT_APP_API_URL}fishingClassQuickReservations/${fishingClassQuickReservationId}`
    );
  },
  deleteFishingClassQuickReservation: (fishingClassQuickReservationId) => {
    return axios.delete(
      `${process.env.REACT_APP_API_URL}fishingClassQuickReservations/${fishingClassQuickReservationId}`
    );
  },
  getAllFishingClassQuickReservationByClient: (clientId) => {
    return axios.get(
      `${process.env.REACT_APP_API_URL}fishingClassQuickReservationsByClient/${clientId}`
    );
  },
  getAllFinishedFishingClassQuickReservationByClient: (clientId) => {
    return axios.get(
      `${process.env.REACT_APP_API_URL}finishedFishingClassQuickReservationsByClient/${clientId}`
    );
  },
  getAllFishingClassQuickReservationAtPresentByClient: (clientId) => {
    return axios.get(
      `${process.env.REACT_APP_API_URL}fishingClassQuickReservationsAtPresentByClient/${clientId}`
    );
  },
  getAllFinishedFishingClassQuickReservationByClientSortedByDateAsc: (
    clientId
  ) => {
    return axios.get(
      `${process.env.REACT_APP_API_URL}finishedFishingClassQuickReservationsByClientSortedByDateAsc/${clientId}`
    );
  },
  getAllFinishedFishingClassQuickReservationByClientSortedByDateDesc: (
    clientId
  ) => {
    return axios.get(
      `${process.env.REACT_APP_API_URL}finishedFishingClassQuickReservationsByClientSortedByDateDesc/${clientId}`
    );
  },
  getAllFinishedFishingClassQuickReservationByClientSortedByDurationAsc: (
    clientId
  ) => {
    return axios.get(
      `${process.env.REACT_APP_API_URL}finishedFishingClassQuickReservationsByClientSortedByDurationAsc/${clientId}`
    );
  },
  getAllFinishedFishingClassQuickReservationByClientSortedByDurationDesc: (
    clientId
  ) => {
    return axios.get(
      `${process.env.REACT_APP_API_URL}finishedFishingClassQuickReservationsByClientSortedByDurationDesc/${clientId}`
    );
  },

  ///////////////////////////// FishingClassBehavioralRule //////////////////////////////////////////////

  getBehavioralRuleByFishingClass: (fishingClassId) => {
    return axios.get(
      `${process.env.REACT_APP_API_URL}behavioralRule?fishingClassId=${fishingClassId}`
    );
  },
  getAllFishingClassBehavioralRules: () => {
    return axios.post(
      `${process.env.REACT_APP_API_URL}fishingClassBehavioralRules`,
      fishingClass
    );
  },
  getFishingClassBehavioralRuleById: (behavioralRuleId) => {
    return axios.get(
      `${process.env.REACT_APP_API_URL}fishingClassBehavioralRules/${behavioralRuleId}`
    );
  },
  createFishingClassBehavioralRule: (behavioralRuleId) => {
    return axios.post(
      `${process.env.REACT_APP_API_URL}fishingClassBehavioralRules/${behavioralRuleId}`,
      cottage
    );
  },
  updateFishingClassBehavioralRule: (behavioralRuleId) => {
    return axios.put(
      `${process.env.REACT_APP_API_URL}fishingClassBehavioralRules/${behavioralRuleId}`
    );
  },
  deleteFishingClassBehavioralRule: (fishingClassId) => {
    return axios.delete(
      `${process.env.REACT_APP_API_URL}fishingClassBehavioralRules/${behavioralRuleId}`
    );
  },

  ///////////////////////////// FishingClassComplaint //////////////////////////////////////////////

  getAllFishingClassComplaints: () => {
    return axios.post(
      `${process.env.REACT_APP_API_URL}fishingClassComplaints`,
      fishingClass
    );
  },
  getFishingClassComplaintById: (complaintId) => {
    return axios.get(
      `${process.env.REACT_APP_API_URL}fishingClassComplaints/${complaintId}`
    );
  },
  createFishingClassComplaint: (complaintId) => {
    return axios.post(
      `${process.env.REACT_APP_API_URL}fishingClassComplaints/${complaintId}`,
      cottage
    );
  },
  updateFishingClassComplaint: (complaintId) => {
    return axios.put(
      `${process.env.REACT_APP_API_URL}fishingClassComplaints/${complaintId}`
    );
  },
  deleteFishingClassComplaint: (complaintId) => {
    return axios.delete(
      `${process.env.REACT_APP_API_URL}fishingClassComplaints/${complaintId}`
    );
  },

  ///////////////////////////// FishingClass RATE//////////////////////////////////////////////

  getAllFishingClassRates: () => {
    return axios.post(
      `${process.env.REACT_APP_API_URL}fishingClassRates`,
      fishingClass
    );
  },
  getFishingClassRateById: (complaintId) => {
    return axios.get(
      `${process.env.REACT_APP_API_URL}fishingClassRates/${complaintId}`
    );
  },
  createFishingClassRate: (complaintId) => {
    return axios.post(
      `${process.env.REACT_APP_API_URL}fishingClassRates/${complaintId}`,
      cottage
    );
  },
  updateFishingClassRate: (complaintId) => {
    return axios.put(
      `${process.env.REACT_APP_API_URL}fishingClassRates/${complaintId}`
    );
  },
  deleteFishingClassRate: (complaintId) => {
    return axios.delete(
      `${process.env.REACT_APP_API_URL}fishingClassRates/${complaintId}`
    );
  },

  ///////////////////////////// FishingClass REPORTS//////////////////////////////////////////////

  getAllFishingClassReports: () => {
    return axios.post(
      `${process.env.REACT_APP_API_URL}fishingClassReports`,
      fishingClass
    );
  },
  getFishingClassReportById: (reportId) => {
    return axios.get(
      `${process.env.REACT_APP_API_URL}fishingClassReports/${reportId}`
    );
  },
  createFishingClassReport: (reportId) => {
    return axios.post(
      `${process.env.REACT_APP_API_URL}fishingClassReports/${reportId}`,
      cottage
    );
  },
  updateFishingClassReport: (reportId) => {
    return axios.put(
      `${process.env.REACT_APP_API_URL}fishingClassReports/${reportId}`
    );
  },
  deleteFishingClassReport: (reportId) => {
    return axios.delete(
      `${process.env.REACT_APP_API_URL}fishingClassReports/${reportId}`
    );
  },

  ///////////////////////////// FishingClass Equipments//////////////////////////////////////////////

  getFishingEquipmentByFishingClassReservation: (fishingClassReservationId) => {
    return axios.post(
      `${process.env.REACT_APP_API_URL}fishingEquipment?fishingClassReservationId=${fishingClassReservationId}`,
      fishingClass
    );
  },
  getAllFishingEquipments: () => {
    return axios.post(
      `${process.env.REACT_APP_API_URL}fishingEquipments`,
      fishingClass
    );
  },
  getFishingEquipmentById: (fishingEquipmentId) => {
    return axios.get(
      `${process.env.REACT_APP_API_URL}fishingEquipments/${fishingEquipmentId}`
    );
  },
  createFishingEquipment: (fishingEquipmentId) => {
    return axios.post(
      `${process.env.REACT_APP_API_URL}fishingEquipments/${fishingEquipmentId}`,
      cottage
    );
  },
  updateFishingEquipment: (fishingEquipmentId) => {
    return axios.put(
      `${process.env.REACT_APP_API_URL}fishingEquipments/${fishingEquipmentId}`
    );
  },
  deleteFishingEquipment: (fishingEquipmentId) => {
    return axios.delete(
      `${process.env.REACT_APP_API_URL}fishingEquipments/${fishingEquipmentId}`
    );
  },
};

export default fishingClassServices;
