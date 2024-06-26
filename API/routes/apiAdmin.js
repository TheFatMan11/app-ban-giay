var express = require('express');
var router = express.Router();
var ctrl = require("../controller/ctrlAdmin")
var mdw = require('../midleware/api_authen');
var multer = require('multer');
var objUpload = new multer({dest:'./tmp'});
;

router.get("/login",ctrl.ScreenLogin)
router.post("/login", ctrl.Login);
router.get("/product",ctrl.XemDanhSachSanPham)

router.get("/product/add", ctrl.ThemSanPham)
router.post("/product/add",objUpload.single("imgAnh"),ctrl.ThemSanPham)

router.get("/product/edit/:id",ctrl.SuaSanPham)
router.post("/product/edit/:id",objUpload.single("imgAnh"),ctrl.SuaSanPham)


router.get("/product/add", ctrl.renderAddProductForm);
// router.delete("/product/delete/:id", ctrl.Xoa);

router.get("/product/delete/:id", ctrl.XoaSanPham);
router.delete("/product/delete/:id",objUpload.single("imgAnh"),ctrl.XoaSanPham)

router.get("/category", ctrl.getCategory);
router.get("/category",ctrl.XemLoai)
router.get("/category/add",ctrl.ThemLoai)
router.post("/category/add",ctrl.ThemLoai)

router.get("/category/edit/:id",ctrl.SuaLoai)
router.post("/category/edit/:id",ctrl.SuaLoai)

router.get("/category/delete/:id",ctrl.Xoaloai)
router.delete("/category/delete/:id",ctrl.Xoaloai)


router.get('/billDangXuLy', ctrl.getHoaDonDangXuLy);
router.get('/billDaDuyet', ctrl.getHoaDonDuyet);
router.get('/billTuChoi', ctrl.getHoaDonTuChoi);
router.get('/allbill', ctrl.getAllHoaDon);

router.get('/listRecharge', ctrl.getRecharge);
router.post('/:rechargeId/confirm', ctrl.confirmRecharge)
router.post('/:rechargeId/reject', ctrl.rejectRecharge);

router.post("/total/bill",ctrl.DanhSachBillDetailToMonth)






module.exports = router;
