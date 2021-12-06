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
      fishingClass
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
  createFishingClassReservation: (fishingClassReservation) => {
    return axios.post(
      `${process.env.REACT_APP_API_URL}fishingClassReservations`,
      fishingClassReservation
    );
  },
  updateFishingClassReservation: (fishingClassReservation) => {
    return axios.put(
      `${process.env.REACT_APP_API_URL}fishingClassReservations/${fishingClassReservation.id}`,
      fishingClassReservation
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
  createFishingClassQuickReservation: (fishingClassQuickReservation) => {
    return axios.post(
      `${process.env.REACT_APP_API_URL}fishingClassQuickReservations`,
      fishingClassQuickReservation
    );
  },
  updateFishingClassQuickReservation: (fishingClassQuickReservation) => {
    return axios.put(
      `${process.env.REACT_APP_API_URL}fishingClassQuickReservations/${fishingClassQuickReservation.id}`,
      fishingClassQuickReservation
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
    return axios.get(
      `${process.env.REACT_APP_API_URL}fishingClassBehavioralRules`
    );
  },
  getFishingClassBehavioralRuleById: (behavioralRuleId) => {
    return axios.get(
      `${process.env.REACT_APP_API_URL}fishingClassBehavioralRules/${behavioralRuleId}`
    );
  },
  createFishingClassBehavioralRule: (fishingClassBehavioralRule) => {
    return axios.post(
      `${process.env.REACT_APP_API_URL}fishingClassBehavioralRules`,
      fishingClassBehavioralRule
    );
  },
  updateFishingClassBehavioralRule: (behavioralRule) => {
    return axios.put(
      `${process.env.REACT_APP_API_URL}fishingClassBehavioralRules/${behavioralRule.id}`,
      behavioralRule
    );
  },
  deleteFishingClassBehavioralRule: (behavioralRuleId) => {
    return axios.delete(
      `${process.env.REACT_APP_API_URL}fishingClassBehavioralRules/${behavioralRuleId}`
    );
  },

  ///////////////////////////// FishingClassComplaint //////////////////////////////////////////////

  getAllFishingClassComplaints: () => {
    return axios.get(`${process.env.REACT_APP_API_URL}fishingClassComplaints`);
  },
  getFishingClassComplaintById: (complaintId) => {
    return axios.get(
      `${process.env.REACT_APP_API_URL}fishingClassComplaints/${complaintId}`
    );
  },
  createFishingClassComplaint: (fishingClassComplaint) => {
    return axios.post(
      `${process.env.REACT_APP_API_URL}fishingClassComplaints`,
      fishingClassComplaint
    );
  },
  updateFishingClassComplaint: (complaint) => {
    return axios.put(
      `${process.env.REACT_APP_API_URL}fishingClassComplaints/${complaint.id}`,
      complaint
    );
  },
  deleteFishingClassComplaint: (complaintId) => {
    return axios.delete(
      `${process.env.REACT_APP_API_URL}fishingClassComplaints/${complaintId}`
    );
  },

  ///////////////////////////// FishingClass RATE//////////////////////////////////////////////

  getAllFishingClassRates: () => {
    return axios.get(`${process.env.REACT_APP_API_URL}fishingClassRates`);
  },
  getFishingClassRateById: (rateId) => {
    return axios.get(
      `${process.env.REACT_APP_API_URL}fishingClassRates/${rateId}`
    );
  },
  createFishingClassRate: (rate) => {
    return axios.post(
      `${process.env.REACT_APP_API_URL}fishingClassRates`,
      rate
    );
  },
  updateFishingClassRate: (rate) => {
    return axios.put(
      `${process.env.REACT_APP_API_URL}fishingClassRates/${rate.id}`,
      rate
    );
  },
  deleteFishingClassRate: (rateId) => {
    return axios.delete(
      `${process.env.REACT_APP_API_URL}fishingClassRates/${rateId}`
    );
  },

  ///////////////////////////// FishingClass REPORTS//////////////////////////////////////////////

  getAllFishingClassReports: () => {
    return axios.get(`${process.env.REACT_APP_API_URL}fishingClassReports`);
  },
  getFishingClassReportById: (reportId) => {
    return axios.get(
      `${process.env.REACT_APP_API_URL}fishingClassReports/${reportId}`
    );
  },
  createFishingClassReport: (fishingClassReport) => {
    return axios.post(
      `${process.env.REACT_APP_API_URL}fishingClassReports`,
      fishingClassReport
    );
  },
  updateFishingClassReport: (report) => {
    return axios.put(
      `${process.env.REACT_APP_API_URL}fishingClassReports/${report.id}`,
      report
    );
  },
  deleteFishingClassReport: (reportId) => {
    return axios.delete(
      `${process.env.REACT_APP_API_URL}fishingClassReports/${reportId}`
    );
  },

  ///////////////////////////// FishingClass Equipments//////////////////////////////////////////////

  getFishingEquipmentByFishingClassReservation: (fishingClassReservationId) => {
    return axios.get(
      `${process.env.REACT_APP_API_URL}fishingEquipment?fishingClassReservationId=${fishingClassReservationId}`
    );
  },
  getAllFishingEquipments: () => {
    return axios.get(`${process.env.REACT_APP_API_URL}fishingEquipments`);
  },
  getFishingEquipmentById: (fishingEquipmentId) => {
    return axios.get(
      `${process.env.REACT_APP_API_URL}fishingEquipments/${fishingEquipmentId}`
    );
  },
  createFishingEquipment: (fishingEquipment) => {
    return axios.post(
      `${process.env.REACT_APP_API_URL}fishingEquipments`,
      fishingEquipment
    );
  },
  updateFishingEquipment: (fishingEquipment) => {
    return axios.put(
      `${process.env.REACT_APP_API_URL}fishingEquipments/${fishingEquipment.id}`,
      fishingEquipment
    );
  },
  deleteFishingEquipment: (fishingEquipmentId) => {
    return axios.delete(
      `${process.env.REACT_APP_API_URL}fishingEquipments/${fishingEquipmentId}`
    );
  },
};

export default fishingClassServices;
